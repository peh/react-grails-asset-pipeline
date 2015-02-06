grails.project.work.dir = 'target'

grails.project.dependency.resolution = {

    inherits 'global'
    log 'warn'

    repositories {
        grailsCentral()
        mavenCentral()
        jcenter()
        mavenRepo "https://raw.github.com/peh/errbuddy-plugins/mvn-repo"
    }

    dependencies {
        compile 'net.errbuddy.plugins:react-asset-pipeline:1.0.5'
    }
    plugins {

        runtime ":asset-pipeline:2.1.1"

        build ':release:2.2.1', ':rest-client-builder:1.0.3', {
            export = false
        }
    }
}