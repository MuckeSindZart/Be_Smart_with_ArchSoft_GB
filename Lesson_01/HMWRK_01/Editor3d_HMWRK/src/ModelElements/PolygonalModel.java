package ModelElements;

import java.util.ArrayList;
import java.util.List;

import Stuff.Point3D;

public class PolygonalModel {
    public List<Texture> textures;
    public List<Polygon> polygons;

    public PolygonalModel(List<Texture> textures) {
        this.polygons = new ArrayList<>();
        this.textures = textures;

        this.polygons.add(new Polygon(new Point3D()));
    }

}
