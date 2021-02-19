public class Planet{
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;
	private static final double G = 6.67e-11;
	public Planet(double xP,double yP,double xV,double yV,double m,String img){
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}

	public Planet(Planet p){
		xxPos = p.xxPos;
		yyPos = p.yyPos;
		xxVel = p.xxVel;
		yyVel = p.yyVel;
		mass = p.mass;
		imgFileName = p.imgFileName;
	}

	public double calcDistance(Planet p){
		return Math.sqrt( (p.xxPos - xxPos) * (p.xxPos - xxPos) + (p.yyPos - yyPos) * (p.yyPos - yyPos) );
	}

	public double calcForceExertedBy(Planet p){
		return G * p.mass * mass / (calcDistance(p) * calcDistance(p));
	}

	public double calcForceExertedByX(Planet p){
		return calcForceExertedBy(p)*((p.xxPos - xxPos) / calcDistance(p));
	}

	public double calcForceExertedByY(Planet p){
		return calcForceExertedBy(p)*((p.yyPos - yyPos) / calcDistance(p));
	}

	public double calcNetForceExertedByX(Planet[] allPlanets){
		double res = 0;
		for(Planet p : allPlanets){
			if(this.equals(p))continue;
			res += calcForceExertedByX(p);
		}
		return res;
	}

	public double calcNetForceExertedByY(Planet[] allPlanets){
		double res = 0;
		for(Planet p : allPlanets){
			if(this.equals(p))continue;
			res += calcForceExertedByY(p);
		}
		return res;
	}

	public void update(double accelerTime, double NetForce_X,double NetForce_Y){
		xxVel = xxVel + accelerTime *  calcAccelerationByX(NetForce_X);
		yyVel = yyVel + accelerTime *  calcAccelerationByY(NetForce_Y);
		xxPos = xxPos + accelerTime * xxVel; 
		yyPos = yyPos + accelerTime * yyVel;
	}

	private double calcAccelerationByX(double NetForce_X){
		return NetForce_X / mass;
	}

	private double calcAccelerationByY(double NetForce_Y){
		return NetForce_Y / mass;
	}

	public void draw(){
		StdDraw.picture(xxPos, yyPos, "images/"+imgFileName);
		StdDraw.show();
	}
}