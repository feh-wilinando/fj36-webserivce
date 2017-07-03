package br.com.caelum.fj36.webservice;

import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.wildfly.swarm.Swarm;
import org.wildfly.swarm.undertow.WARArchive;

/**
 * Created by nando on 03/07/17.
 */
public class Application {

    public static void main(String[] args) throws Exception {
        Swarm swarm = new Swarm(args);

        swarm.start();

        WARArchive deployment = ShrinkWrap.create(WARArchive.class);

        deployment.addPackages(true, Package.getPackage("br.com.caelum.fj36.webservice"));

        deployment.addAllDependencies();

        swarm.deploy(deployment);

    }

}
