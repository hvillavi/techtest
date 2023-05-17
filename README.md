# Prueba Técnica Equifax
## Backend

## Instrucciones de Instalación
1. El DDL se encuentra en el directorio ddl del proyecto.
2. El proyecto se compila y ejecuta con SDK 11.
3. La aplicación fue probada con postgresql 15.3-1
4. Para levantar los servicios, debe ejecutar la clase com.equifax.techtest.Application

## Servicio de Autenticación
1. Si levanta los servicios localmente, puede ejecutar el servicio de autenticación haciendo un POST a http://localhost:8080/authenticate
2. Deberá enviar los parámetros como json de la forma {"username": "usuario", "password": "contraseña"}
3. Si el usuario y password son correctos, retornará un token de autenticación con un mensaje de la forma
{
    "token": "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c3VhcmlvIiwiaWF0IjoxNjg0MzE4ODMyLCJleHAiOjE2ODQzNTQ4MzJ9.tRi1yhf3EE5FyQIhX57mvJJ0GlHFA1UGq8h6vgDZljM"
}
4. En otro caso, retornará un status 403

## Servicio información de coordenada
1. Para ejecutar el servicio, hacer un GET de la forma http://localhost:8080/tabla1/tabla1?lat=1&lng=2
2. En los Headers, agregar la Key Authorization y ponerle el valor "Bearer <token>". Por ejemplo, Authorization: Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJ1c3VhcmlvIiwiaWF0IjoxNjg0MzE4ODMyLCJleHAiOjE2ODQzNTQ4MzJ9.tRi1yhf3EE5FyQIhX57mvJJ0GlHFA1UGq8h6vgDZljM
3. El servicio debería retornar un json de la forma
{
    "lat_input": "1",
    "lng_input": "2",
    "datos": {
        "campo1": "info11",
        "campo2": "info12"
    }
}

## Tests unitarios
1. Sólo hay un test unitario que se encuentra en com.equifax.techtest.service.JwtUserDetailsServiceTest
2. Para ejecutarlo, hay que ejecutar el test loadUserByUsername()
