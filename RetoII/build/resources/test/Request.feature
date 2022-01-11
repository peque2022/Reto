Feature: Reto
Scenario: Como usuario quiero crear una reserva

  Given Tengo acceso al api de crear reserva
  When ejecuto un metodo post a "https://restful-booker.herokuapp.com/booking" con el body
  """
    {
      "firstname":"Elizabeth",
      "lastname" : "Gamarra",
      "totalprice" : 222,
      "depositpaid" : true,
      "bookingdates" : [
          "checkin" : "2018-01-01",
          "checkout" : "2019-01-01"
      ],
      "additionalneeds" : "Lunch"
    }
    """
  Then se espera que el codigo de respuesta sea 200

