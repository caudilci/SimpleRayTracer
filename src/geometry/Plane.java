package geometry;

import utils.Color;
import utils.Normal;
import utils.Point3D;
import utils.Ray;

public class Plane extends GeometricObject {
    public Point3D point;
    public Normal normal;
    public Color color;

    // Definition of Plane: (p-a)*n=0
    public Plane(Point3D point, Normal normal, Color color) {
        this.point = new Point3D(point);
        this.normal = new Normal(normal);
        this.color = new Color(color);
    }

    //To find collision: (o+t*d-a)*n=0
    // t= (o-a)*n/d*n
    @Override
    public double hit(Ray ray) {
        double t = point.subtract(ray.origin).dot(normal)/ray.direction.dot(normal);
        if(t > 10E-9){
            return t;
        }
        else return 0;
    }
}