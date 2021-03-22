import static org.junit.jupiter.api.Assertions.*;

 class BonusServiceTest {

    @org.junit.jupiter.api.Test
    void shouldCalculateForRegisteredAndUnderLimit() {
        BonusService service = new BonusService();

        // подготавливаем данные:
        long amount = 1000_60;
        boolean registered = true;
        //ожидаемый результат
        long expected = 30;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void shouldCalculateForRegisteredAndOverLimit() {
        BonusService service = new BonusService();

        // подготавливаем данные:
        long amount = 1_000_000_60;
        boolean registered = true;
        //ожидаемый результат
        long expected = 500;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        assertEquals(expected, actual);
    }
     @org.junit.jupiter.api.Test
     void shouldCalculateForNotRegisteredAndOverLimit() {
         BonusService service = new BonusService();

         // подготавливаем данные:
         //сумма бонусов выше лимита
         long amount = 5_000_000_00;
         //незарегистрированный юзер
         boolean registered = false;
         //ожидаемый результат
         long expected = 500;

         // вызываем целевой метод:
         long actual = service.calculate(amount, registered);

         // производим проверку (сравниваем ожидаемый и фактический):
         assertEquals(expected, actual);
     }
     @org.junit.jupiter.api.Test
     void shouldCalculateForNotRegisteredAndUnderLimit() {
         BonusService service = new BonusService();

         // подготавливаем данные:
         //сумма бонусов ниже лимита
         long amount = 10_000_00;
         //незарегистрированный юзер
         boolean registered = false;
         //ожидаемый результат
         long expected = 100;

         // вызываем целевой метод:
         long actual = service.calculate(amount, registered);

         // производим проверку (сравниваем ожидаемый и фактический):
         assertEquals(expected, actual);
     }
     @org.junit.jupiter.api.Test
     void shouldCalculateForNotRegisteredAndNullLimit() {
         BonusService service = new BonusService();

         // подготавливаем данные:
         //сумма бонусов равна нулю
         long amount = 0;
         //незарегистрированный юзер
         boolean registered = true;
         //ожидаемый результат
         long expected = 0;

         // вызываем целевой метод:
         long actual = service.calculate(amount, registered);

         // производим проверку (сравниваем ожидаемый и фактический):
         assertEquals(expected, actual);
     }
     @org.junit.jupiter.api.Test
     void shouldCalculateForNotRegisteredAndNegativeAmount() {
         BonusService service = new BonusService();

         // подготавливаем данные:
         //Отрицательная / негативная сумма бонусов ниже лимита
         long amount = - 1000;
         //незарегистрированный юзер
         boolean registered = true;
         //ожидаемый результат
         long expected = 0;
         // вызываем целевой метод:
         long actual = service.calculate(amount, registered);

         // производим проверку (сравниваем ожидаемый и фактический):
         assertEquals(expected, actual);
     }

}