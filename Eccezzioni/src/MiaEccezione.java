public class MiaEccezione extends Exception { //fatta di exception perchè la volevamo checked
    public MiaEccezione(String message) {
      super(message);
    }
}
