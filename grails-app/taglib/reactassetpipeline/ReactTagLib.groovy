package reactassetpipeline

class ReactTagLib {
	static namespace = "asset"
    static defaultEncodeAs = [taglib:'raw']
    //static encodeAsForTags = [tagName: [taglib:'html'], otherTagName: [taglib:'none']]

    def reactTemplate = {attrs ->
        def src = attrs.remove('src')
        attrs.remove('href')
        src = "${asset.pipeline.AssetHelper.nameWithoutExtension(src)}.jsx"
    	out << "<script src='${assetPath(src:src)}' type='text/javascript'></script>"
    }
}
