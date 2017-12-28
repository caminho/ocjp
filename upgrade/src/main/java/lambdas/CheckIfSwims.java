package lambdas;

class CheckIfSwims implements CheckTrait {
    @Override
    public boolean test(Animal a) {
        return a.canSwim();
    }
}
