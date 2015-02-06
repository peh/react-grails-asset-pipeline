package reactassetpipeline

class ReactTagLib {
	static namespace = "asset"
    static defaultEncodeAs = [taglib:'raw']
    //static encodeAsForTags = [tagName: [taglib:'html'], otherTagName: [taglib:'none']]

    def reactTemplate = {attrs ->
    	if(!attrs.src)
    		throwTagError("Missing attribute [src]")
    	out << "<script src='${assetPath(src:attrs.src)}' type='text/javascript'></script>"
    }
}
