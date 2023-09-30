package ModelElements;

import java.util.List;

public class Scene {
    public Integer id;
    public List<PolygonalModel> models;
    public List<Flash> flashes;
    public List<Camera> cameras;

    public Scene(Integer id, List<PolygonalModel> models, List<Flash> flashes, List<Camera> cameras) throws Exception {

        this.id = id;
        this.flashes = flashes;

        if (models.size() > 0) {
            this.models = models;
        } else {
            throw new Exception("Должна быть одна модель");
        }

        if (cameras.size() > 0) {
            this.cameras = cameras;
        } else {
            throw new Exception("Должна быть одна камера");
        }
    }

    public <Type> Type method1(Type flash) {
        Type result = null;
        return result;
    }

    public <Type, Type2> Type method2(Type Model, Type2 flash) {
        Type result = null;
        return result;
    }



}
