package InMemoryModel;

import java.util.ArrayList;
import java.util.List;

import ModelElements.Camera;
import ModelElements.Flash;
import ModelElements.PolygonalModel;
import ModelElements.Scene;
import ModelElements.Texture;

public class ModelStore implements iModelChanger {
    public List<PolygonalModel> models;
    public List<Scene> scenes;
    public List<Flash> flashes;
    public List<Camera> cameras;
    private iModelChangeObserver[] changeObservers;

    public ModelStore(iModelChangeObserver[] changeObservers) throws Exception {
        this.changeObservers = changeObservers;

        this.models = new ArrayList<PolygonalModel>();
        this.scenes = new ArrayList<Scene>();
        this.flashes = new ArrayList<Flash>();
        this.cameras = new ArrayList<Camera>();

        List<Texture> textures = new ArrayList<>();
        models.add(new PolygonalModel(textures));
        flashes.add(new Flash());
        cameras.add(new Camera());
        scenes.add(new Scene(0, models, flashes, cameras));
    }

    
    public Scene getScene(Integer id)
    {
        for (Scene scene : scenes) {
            if (scene.id.equals(id)) {
                return scene;
            }
        }
        return null;
    }

    @Override
    public void NotifyChange(iModelChanger sender) {
        
    }


    
}
