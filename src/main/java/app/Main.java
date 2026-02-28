package app;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        int VelocidadMaxDefinida = 60;
        String fabricanteFiltrar = "LuaOjete";

        // creacio de objectes
        RobotTerrestre robotTerrestre1 = new RobotTerrestre("pepo", "DaniSA", 2001, 15, RobotTerrestre.Traccion.ORUGA);
        RobotTerrestre robotTerrestre2 = new RobotTerrestre("tete", "LuaOjete", 2011, 115, RobotTerrestre.Traccion.RUEDAS);
        RobotTerrestre robotTerrestre3 = new RobotTerrestre("ShoshoTank", "RoboCorp", 2022, 40, RobotTerrestre.Traccion.ORUGA);

        RobotAcuatico robotAcuatico1 = new RobotAcuatico("AquaRunner", "AquaTech", 2021, RobotAcuatico.Propulsion.HELICE, 500);
        RobotAcuatico robotAcuatico2 = new RobotAcuatico("DeepBlue", "LuaOjete", 2020, RobotAcuatico.Propulsion.CHORRO, 800);
        RobotAcuatico robotAcuatico3 = new RobotAcuatico("SeaExplorer", "OceanicCorp", 2023, RobotAcuatico.Propulsion.HELICE, 300);

        RobotAereo robotAereo1 = new RobotAereo("SkyX-1", "AeroDynamics", 2023, 3000, 75);
        RobotAereo robotAereo2 = new RobotAereo("FlyBot-3", "LuaOjete", 2022, 2500, 45);
        RobotAereo robotAereo3 = new RobotAereo("CloudRider", "AirTech", 2021, 4000, 120);

        //ficar tts a un allista generica  de Robots
        List<Robot> listaRobots = List.of(robotTerrestre1, robotTerrestre2, robotTerrestre3, robotAcuatico1, robotAcuatico2, robotAcuatico3, robotAereo1, robotAereo2, robotAereo3);


        //Listar todos los robots registrados con su descripción técnica.
        listaRobots.stream() // fa el mateix que l'anterior
                .map(robot -> robot.getTechnicalDescription())
                .forEach(robot -> System.out.println(robot));


        //Filtrar robots terrestres con velocidad mayor a X km/h.
        List<RobotTerrestre> llistaRobotsTerrestresVelocitatMaximaDefinida = listaRobots.stream()
                .filter(robot -> robot instanceof RobotTerrestre)
                .map(robot -> (RobotTerrestre) robot)
                .filter(robot -> robot.getVelocidadMaxima() >= VelocidadMaxDefinida)
                .toList();

        //Buscar robots por fabricante (sin importar el tipo).
        System.out.println(buscarPorFabricante(fabricanteFiltrar, listaRobots));


        //llistar el sque son compatibles amb sortir al infrome
        ResistanceReportPrinter imprimidor = new ResistanceReportPrinter();

        List<ResistanceEvaluable> listaReportables = listaRobots.stream()
                .filter(robot -> robot instanceof ResistanceEvaluable)
                .map(robot -> (ResistanceEvaluable) robot)
                .toList();

        imprimidor.printReport(listaReportables);

        //imprimidor.printReport(listaRobots);
    }

    public static List<Robot> buscarPorFabricante(String fabricante, List<Robot> lista) {
        List<Robot> listaConEsePutoFabricante = lista.stream()
                .filter(robot -> robot.getFabricante() == fabricante)
                .toList();

        return listaConEsePutoFabricante;

    }


}
