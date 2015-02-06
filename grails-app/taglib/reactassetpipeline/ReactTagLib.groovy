package reactassetpipeline

import grails.util.Environment

class ReactTagLib {
	static namespace = "asset"
    static defaultEncodeAs = [taglib:'raw']
    //static encodeAsForTags = [tagName: [taglib:'html'], otherTagName: [taglib:'none']]

    def reactTemplate = {attrs ->
        def src = attrs.remove('src')
        attrs.remove('href')
        src = "${asset.pipeline.AssetHelper.nameWithoutExtension(src)}.jsx"
        def uri
        def extension

        def conf = grailsApplication.config.grails.assets
        def debugParameter = params."_debugResources" == 'y' || params."_debugAssets" == "y"
        def debugMode = (conf.allowDebugParam && debugParameter) ||  (Environment.current == Environment.DEVELOPMENT && !grailsApplication.warDeployed && conf.bundle != true)

        if(!debugMode) {
            out << "<script src=\"${assetPath(src:src)}\" type=\"text/javascript\" ${paramsToHtmlAttr(attrs)}></script>"
        } else {
            if (src.lastIndexOf(".") >= 0) {
                uri = src.substring(0, src.lastIndexOf("."))
                extension = src.substring(src.lastIndexOf(".") + 1)
            } else {
                uri = src
                extension = 'js'
            }
            // def startTime = new Date().time
            def list = asset.pipeline.AssetPipeline.getDependencyList(uri, 'application/javascript', extension)
            def modifierParams = ["compile=false"]
            if(attrs.charset) {
                modifierParams << "encoding=${attrs.charset}"
            }
            list.each { dep ->
                def depAssetPath = assetPath([src: "${dep.path}", ignorePrefix:true])
                out << "<script src=\"${depAssetPath}?${modifierParams.join("&")}\" type=\"text/javascript\" ${paramsToHtmlAttr(attrs)}></script>${LINE_BREAK}"
            }
            // println "Fetching Dev Mode Dependency List Time ${new Date().time - startTime}"
        }
    }
}
