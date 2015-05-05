package reactassetpipeline

import grails.util.Environment
import grails.core.GrailsApplication

class ReactTagLib {
    static namespace = "asset"
    static defaultEncodeAs = [taglib:'raw']
    GrailsApplication grailsApplication
    //static encodeAsForTags = [tagName: [taglib:'html'], otherTagName: [taglib:'none']]

    def reactTemplate = {attrs ->
        def src = attrs.remove('src')
        attrs.remove('href') 

        def conf = grailsApplication.config.grails.assets
        def debugParameter = params."_debugResources" == 'y' || params."_debugAssets" == "y"
        def debugMode = (conf.allowDebugParam && debugParameter) ||  (Environment.current == Environment.DEVELOPMENT && !grailsApplication.warDeployed && conf.bundle != true)
        if(debugMode)
            src = "${asset.pipeline.AssetHelper.nameWithoutExtension(src)}.jsx"
        else
            src = "${asset.pipeline.AssetHelper.nameWithoutExtension(src)}.js"
        out << "<script src='${assetPath(src:src)}' type='text/javascript'></script>"
    }
}
