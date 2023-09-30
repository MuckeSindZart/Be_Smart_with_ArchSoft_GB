package ModelElements;

import java.util.ArrayList;
import java.util.List;

import Stuff.Point3D;

public class Polygon {
    public List<Point3D> points = new ArrayList<Point3D>();

    public Polygon(Point3D point) {
        points.add(point);
    }
}
