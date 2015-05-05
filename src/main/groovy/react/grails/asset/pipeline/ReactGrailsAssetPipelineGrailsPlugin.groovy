package react.grails.asset.pipeline

import grails.plugins.*

class ReactGrailsAssetPipelineGrailsPlugin extends Plugin {

    // the version or versions of Grails the plugin is designed for
    def grailsVersion = "3.0.1 > *"
    // resources that are excluded from plugin packaging
    def pluginExcludes = [
        "grails-app/views/error.gsp"
    ]

   def title = "React Asset-Pipeline Plugin"
   def author = "Philipp Eschenbach"
   def authorEmail = "philipp@errbuddy.net"
   def description = "Provides react support for Asset-Pipeline."
   def documentation = "http://github.com/peh/react-grails-asset-pipeline"
   def license = "APACHE"
   def organization = [ name: "errbuddy", url: "https://errbuddy.net/" ]
   def issueManagement = [ system: "GITHUB", url: "http://github.com/peh/react-grails-asset-pipeline/issues" ]
   def scm = [ url: "http://github.com/peh/react-grails-asset-pipeline" ]
   def profiles = ['web']
   def version = "0.1"

   
    // Any additional developers beyond the author specified above.
//    def developers = [ [ name: "Joe Bloggs", email: "joe@bloggs.net" ]]


    Closure doWithSpring() { {->
            // TODO Implement runtime spring config (optional)
        } 
    }

    void doWithDynamicMethods() {
        // TODO Implement registering dynamic methods to classes (optional)
    }

    void doWithApplicationContext() {
        // TODO Implement post initialization spring config (optional)
    }

    void onChange(Map<String, Object> event) {
        // TODO Implement code that is executed when any artefact that this plugin is
        // watching is modified and reloaded. The event contains: event.source,
        // event.application, event.manager, event.ctx, and event.plugin.
    }

    void onConfigChange(Map<String, Object> event) {
        // TODO Implement code that is executed when the project configuration changes.
        // The event is the same as for 'onChange'.
    }

    void onShutdown(Map<String, Object> event) {
        // TODO Implement code that is executed when the application shuts down (optional)
    }
}
