package InMemoryModel;

//Интерфейс смены модели
public interface iModelChanger {
    public void NotifyChange(iModelChanger sender);
}
