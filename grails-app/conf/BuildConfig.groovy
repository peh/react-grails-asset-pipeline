grails.project.work.dir = 'target'

grails.project.dependency.resolution = {

    inherits 'global'
    log 'warn'

    repositories {
        grailsCentral()
        mavenCentral()
        mavenLocal()
        jcenter()
        mavenRepo "http://dl.bintray.com/errbuddy/plugins"
    }

    dependencies {
        compile 'net.errbuddy.plugins:react-asset-pipeline:2.0.0'
    }
    plugins {

        runtime ":asset-pipeline:2.1.1"

        build ':release:2.2.1', ':rest-client-builder:1.0.3', {
            export = false
        }
    }
}