grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
//grails.project.war.file = "target/${appName}-${appVersion}.war"

grails.project.repos.default = 'knowint'
grails.project.dependency.resolver = "maven" // or ivy

grails.project.dependency.distribution = {
    remoteRepository(id:'knowint', url:'http://nexus.k-int.com/content/repositories/releases')
}

grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
        // uncomment to disable ehcache
        // excludes 'ehcache'
    }
    log "warn" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    repositories {
        mavenLocal()
        mavenCentral()
        grailsPlugins()
        grailsHome()
        grailsCentral()
        mavenRepo "http://repo.spring.io/milestone/"

        // uncomment the below to enable remote dependency resolution
        // from public Maven repositories
        //mavenRepo "http://snapshots.repository.codehaus.org"
        //mavenRepo "http://repository.codehaus.org"
        //mavenRepo "http://download.java.net/maven/2/"
        //mavenRepo "http://repository.jboss.com/maven2/"
    }
    dependencies {
        // specify dependencies here under either 'build', 'compile', 'runtime', 'test' or 'provided' scopes eg.

        // runtime 'mysql:mysql-connector-java:5.1.13'
    }
    plugins {

      // build ":tomcat:7.0.53"

      // plugins needed at runtime but not for compilation
      // runtime ":hibernate4:4.3.5.3" // or ":hibernate:3.6.10.15"

      compile ":spring-security-core:2.0-RC4"
      compile ':spring-security-ldap:2.0-RC2'

      test ":code-coverage:2.0.3-2"
      test ":codenarc:0.21"
      test ":gmetrics:0.3.1"

      // For grails maven-install
      build ":release:3.0.1"

    }
}

codenarc.reports = {
	JenkinsXmlReport('xml') {
		outputFile = 'target/test-reports/CodeNarcReport.xml'
		title = 'CodeNarc Report for Grails Spring Security Shibboleth Native SP plugin'
	}
	JenkinsHtmlReport('html') {
		outputFile = 'CodeNarcReport.html'
		title = 'CodeNarc Report for Grails Spring Security Shibboleth Native SP plugin'
	}
}
codenarc.propertiesFile = 'grails-app/conf/codenarc.properties'
