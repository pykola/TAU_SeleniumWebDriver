package example;

public abstract class Test {

  public static void print(Test test) {
    test.testMethod();
  }

  public abstract void testMethod();


  public static class TestA extends Test {

    @Override
    public void testMethod() {
      System.out.println("hello from TestA");
    }
  }

  public static class TestB extends Test {
    @Override
    public void testMethod() {
      System.out.println("hello from TestB");
    }
  }

  public static void main(String[] args) {
    Test.print(new TestB());
  }
}


