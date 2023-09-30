package InMemoryModel;


import ModelElements.Camera;
import ModelElements.PolygonalModel;
import ModelElements.Scene;
import ModelElements.Flash;

import java.util.ArrayList;
import java.util.List;

public class ModelStore implements iModelChanger {
    public List<PolygonalModel> models ;
    public List<Scene> scenes;
    public List<Flash> flashes;
    public List<Camera> camera;

    private iModelChangedObserver[] changedObservers;


    public ModelStore(iModelChangedObserver[] changedObservers) {
        this.changedObservers = changedObservers;

        this.models = new ArrayList<PolygonalModel>();
        this.scenes = new ArrayList<Scene>();
        this.flashes = new ArrayList<Flash>();
        this.camera = new ArrayList<Camera>();
    }
    public Scene getScene(int id) {
        for (int i = 0; i < scenes.size(); i++) {
            return scenes.get(id);
        }
        return null;
    }

    @Override
    public void NotifyChange(iModelChanger sender) {
    }
}
