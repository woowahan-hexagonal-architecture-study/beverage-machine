package woowastudy.beverage.outgoingport;

// TODO 다소 높은 추상화로된 인터페이스라, 구현받을 어댑터가 ISP를 위반할 수 있을수도 있음.
//  하지만 아직 비즈니스 구현부가 복잡하지 않으니 이정도로 타협하는것이 좋을 것 같음. (추후 수정)
public interface BeverageStockRepository {
    void release(int beverageId, int quantity);
}
