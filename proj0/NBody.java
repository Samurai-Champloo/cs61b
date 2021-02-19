public class NBody{

	public static double readRadius(String InputFileName){
		In in = new In(InputFileName);
		in.readInt();
		double radius = in.readDouble();
		return radius;
	}

	public static Planet[] readPlanets(String InputFileName){
		In in = new In(InputFileName);
		int PlanetNum = in.readInt();
		double radius = in.readDouble();
		Planet[] planets = new Planet[PlanetNum];
		for(int i = 0; i < PlanetNum; i++){
			double xxPos = in.readDouble();
			double yyPos = in.readDouble();
			double xxVel = in.readDouble();
			double yyVel = in.readDouble();
			double mass = in.readDouble();
			String img = in.readString();
			planets[i] = new Planet(xxPos,yyPos,xxVel,yyVel,mass,img);
		}
		return planets;
	} 
	public static void main(String[] args){
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		Planet[] planets = readPlanets(filename);
		double radius = readRadius(filename);
		int waitTimeMilliseconds = 10;
		StdDraw.enableDoubleBuffering();
		for(double time = 0; time < T; time+=dt){
			double[] xForces = new double[planets.length];
			double[] yForces = new double[planets.length];
			for(int i = 0; i < planets.length; i++){
				xForces[i] = planets[i].calcNetForceExertedByX(planets);
				yForces[i] = planets[i].calcNetForceExertedByY(planets);
				planets[i].update(dt,xForces[i],yForces[i]);
			}
			drawBackground(radius);
			drawAllplanets(planets);
			StdDraw.show();
			StdDraw.pause(waitTimeMilliseconds);
		}
		StdOut.printf("%d\n",planets.length);
		StdOut.printf("%.2e\n",radius);
		for (int i = 0; i < planets.length; i++) {
    		StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
            planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
            planets[i].yyVel, planets[i].mass, planets[i].imgFileName);   
		}
	}

	private static void drawBackground(double radius){
			StdDraw.setScale(-radius, radius);
			StdDraw.clear();
			StdDraw.picture(-radius, radius, "images/starfield.jpg");
			StdDraw.picture(-radius, -radius, "images/starfield.jpg");
			StdDraw.picture(radius, -radius, "images/starfield.jpg");
			StdDraw.picture(radius, radius, "images/starfield.jpg");
	}
	private static void drawAllplanets(Planet[] planets){
		for(Planet planet : planets){
			planet.draw();
		}
	}
}