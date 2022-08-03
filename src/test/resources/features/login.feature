#language: es

Característica: Login
  Yo, como usuario
  Quiero, tener una opcion para iniciar sesión
  Para ver toos los items

  @test1
  Escenario: Iniciar sesion
    Dado que me encuentro en la página de login e aaucedemo
    Cuando inicio sesión con las credenciales usuario: "standard_user" y contraseña: "secret_sauce"
    Entonces valido que deberia aparecer el título e "PRODUCTS"
    Y también valio que al menos exista un item