# Back End I

## Trabalho integrador:

## Sistema de reserva de consultas

Desejamos implementar um sistema que permita administrar a reserva/marcação de consultas para uma clínica odontológica. Os requisitos que devem ser atendidos são os seguintes:

### Requerimentos técnicos

* Utilizar o MAVEN para gerenciamento de dependências de bibliotecas e frameworks;
* Implementar uma arquitetura de aplicação empresarial em camadas e injeção de dependências;
* Utilizar o padrão MVC proporcionado pelo Spring Framework;
* Utilizar um ORM para acesso a dados e persistência;
* Manter o registro de log da aplicação com o Log4J para facilitar a resolução de problemas (troubleshooting) em caso de erros;
* Sempre manter a prática de realizar testes unitários visando assegurar a qualidade do software.

#### Endpoints da API

##### Dentistas

Lista todos os dentistas
```
GET localhost:8080/dentists
```

Busca dentista por id
```
GET localhost:8080/dentists/{id}
```

Salva um novo dentista
```
POST localhost:8080/dentists

body:
{
    "registrationNumber" : 123456,
    "name" : "Daniel",
    "surname" : "Sousa"
}
```

Atualiza um dentista por id
```
PATCH localhost:8080/dentists/{id}

body:
{
    "registrationNumber" : 123478,
    "name" : "Lucas",
    "surname" : "Sousa"
}
```

Deleta um dentista por id
```
DELETE localhost:8080/dentists
```

Exibe uma lista de pacientes do dentista por id
```
GET localhost:8080/patients/dentists/{id}
```

##### Pacientes

Lista todos os pacientes
```
GET localhost:8080/patients
```

Busca paciente por id
```
GET localhost:8080/patients/{id}
```

Salva um novo paciente
```
POST localhost:8080/patients

body:
{
    {
        "name": "Albert",
        "surname": "Einstein",
        "rg": "987456",
        "address": {
            "street": "Rua 03",
            "number": "75",
            "neighborhood": "Bairro São João",
            "city": "Araguaína",
            "state": "TO",
            "country": "Brasil",
            "zipCode": "77808-614"
        },
        "dentist" : {
            "id" : 1
        }
    }
}
```

Atualiza um paciente por id
```
PATCH localhost:8080/patients/{id}

body:
{
    {
        "name": "Robert",
        "surname": "Einstein",
        "rg": "987456",
        "address": {
            "street": "Rua 03",
            "number": "75",
            "neighborhood": "Bairro São João",
            "city": "Araguaína",
            "state": "TO",
            "country": "Brasil",
            "zipCode": "77808-614"
        },
        "dentist" : {
            "id" : 2
        }
    }
}
```

Deleta um paciente por id
```
DELETE localhost:8080/patients
```
