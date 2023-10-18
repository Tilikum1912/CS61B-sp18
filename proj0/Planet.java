public class Planet {
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    private final static double G = 6.67e-11;

    /** first Planet constructor */
    public Planet(double xP, double yP, double xV,
                  double yV, double m, String img) {
                    xxPos = xP;
                    yyPos = yP;
                    xxVel = xV;
                    yyVel = yV;
                    mass = m;
                    imgFileName = img;
                  }
    
    /** second Planet constructor */
    public Planet(Planet p) {
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }

    public double calcDistance(Planet p2) {
      double dx = this.xxPos - p2.xxPos;
      double dy = this.yyPos - p2.yyPos;
      double r = Math.sqrt(dx * dx + dy * dy);
      return r;
    }

    public double calcForceExertedBy(Planet p2) {
      double r = calcDistance(p2);
      double f = G * this.mass * p2.mass / (r * r);
      return f;
    }

    public double calcForceExertedByX(Planet p2) {
      double f1 = calcForceExertedBy(p2);
      double r = calcDistance(p2);
      double dx = p2.xxPos - this.xxPos;
      double f1x = f1 * dx / r;
      return f1x;
    }

    public double calcForceExertedByY(Planet p2) {
      double f1 = calcForceExertedBy(p2);
      double r = calcDistance(p2);
      double dy = p2.yyPos - this.yyPos;
      double f1y = f1 * dy / r;
      return f1y;
    }

    public double calcNetForceExertedByX(Planet[] ps) {
      double f1x = 0;
      for (Planet pl : ps) {
        if (this.equals(pl)) {
          continue;
        }
        f1x += calcForceExertedByX(pl);
      }
      return f1x;
    }

    public double calcNetForceExertedByY(Planet[] ps) {
      double f1y = 0;
      for (Planet pl : ps) {
        if (this.equals(pl)) {
          continue;
        }
        f1y += calcForceExertedByY(pl);
      }
      return f1y;
    }

    public void update(double dt, double fX, double fY) {
      double ax = fX / this.mass;
      double ay = fY / this.mass;
      xxVel += dt * ax;
      yyVel += dt * ay;
      xxPos += dt * xxVel;
      yyPos += dt * yyVel;
    }

    public void draw() {
      StdDraw.picture(xxPos, yyPos, "images/" + imgFileName);
    }
}