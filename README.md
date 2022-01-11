# fiap-ofertas
Este serviço fornece dois endpoints para disponibilização e seleção de ofertas para caminhoneiros.

## Banco de dados
A aplicação utiliza um banco de dados Mysql. Executar o comando a seguir para subir localmente o banco de dados
- docker-compose up -d

## Compilar e rodar
- mvn clean install
- mvn spring-boot:run

# API
## Cadastro de ofertas de um caminhoneiro
Serve para cadastrar ofertas que serão apresentadas para os caminhoneiros
```
curl -X POST \
  http://localhost:8080/api/ofertas \
  -H 'content-type: application/json' \
  -d '{
	"id Oferta": "id-da-oferta",
	"cpfCaminhoneiro":"num-do-CPF",
	"listRotas": "788,789",
	"conteudoJson": "{'\''id'\'':num, '\''titulo'\'':'\''titulo da oferta'\''}",
	"dtCriacao": "12/10/2020 10:20:50"
}'
```

## Listagem de ofertas de um caminhoneiro
```
curl -X GET \
'http://localhost:8080/api/ofertas?sort=dtCriacao%2Cdesc&cpfCaminhoneiro=cpf-do-caminhoneiro
```
Ex:
```json
{
    "_embedded": {
        "ofertas": [
            {
                "idOferta": id-da-oferta,
                "cpfCaminhoneiro": "cpf-do-caminhoneiro",
                "listRotas": "788,789",
                "conteudoJson": "{'id':num, 'titulo':'titulo da oferta'}",
                "dtCriacao": "12/10/2020 10:20:50",
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/api/ofertas/1"
                    },
                    "oferta": {
                        "href": "http://localhost:8080/api/ofertas/1"
                    }
                }
            }
        ]
    },
    "_links": {
        "self": {
            "href": "http://localhost:8080/api/ofertas?sort=dtCriacao,desc&cpfCaminhoneiro=cpf-do-caminhoneiro"
        },
        "profile": {
            "href": "http://localhost:8080/api/profile/ofertas"
        }
    },
    "page": {
        "size": 20,
        "totalElements": 1,
        "totalPages": 1,
        "number": 0
    }
}

```
## Seleção de ofertas feitas pelo caminhoneiro
Serve para registrar ofertas que foram selecionadas pelo caminhoneiro
```
curl -X POST \
  http://localhost:8080/api/ofertaSelecionada \
  -H 'content-type: application/json' \
  -d '{
	"idOferta": id-da-oferta,
	"cpfCaminhoneiro": "cpf-do-caminhoneiro",
	"conteudoJson": "conteúdo de teste",
	"rota": "http://localhost:8080/api/rota/1"
}'
```

## Listagem das rotas de um caminhoneiro
```
curl -X GET \
  'http://localhost:8080/api/rotas?cpfCaminhoneiro=01234567890' \
  -H 'postman-token: 0515f4c1-152f-7468-2804-5d534adff093'
```
Ex:
```json
{
    "_embedded": {
        "rotas": [
            {
                "idRota": 489,
                "cpfCaminhoneiro": "01234567890",
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/api/rotas/8"
                    },
                    "rota": {
                        "href": "http://localhost:8080/api/rotas/8"
                    },
                    "ofertasSelecionada": {
                        "href": "http://localhost:8080/api/rotas/8/ofertasSelecionada"
                    }
                }
            },
            {
                "idRota": 490,
                "cpfCaminhoneiro": "00870130374",
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/api/rotas/9"
                    },
                    "rota": {
                        "href": "http://localhost:8080/api/rotas/9"
                    },
                    "ofertasSelecionada": {
                        "href": "http://localhost:8080/api/rotas/9/ofertasSelecionada"
                    }
                }
            }
        ]
    },
    "_links": {
        "self": {
            "href": "http://localhost:8080/api/rotas"
        },
        "profile": {
            "href": "http://localhost:8080/api/profile/rotas"
        }
    },
    "page": {
        "size": 20,
        "totalElements": 2,
        "totalPages": 1,
        "number": 0
    }
}
```

## Listagem de ofertas selecionadas pelo caminhoneiro associadas a uma rota
```
curl -X GET \
  http://localhost:8080/api/rotas/9/ofertasSelecionada \
  -H 'cache-control: no-cache' \
  -H 'postman-token: 0a080aff-3dbd-83cd-0f40-49cd10427dc3'
```
Ex:
```json
{
    "_embedded": {
        "ofertaSelecionada": [
            {
                "idOferta": 489,
                "cpfCaminhoneiro": "01234567890",
                "conteudoJson": "conteúdo de teste",
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/api/ofertaSelecionada/12"
                    },
                    "ofertaSelecionada": {
                        "href": "http://localhost:8080/api/ofertaSelecionada/12"
                    },
                    "rota": {
                        "href": "http://localhost:8080/api/ofertaSelecionada/12/rota"
                    }
                }
            },
            {
                "idOferta": 490,
                "cpfCaminhoneiro": "01234567890",
                "conteudoJson": "conteúdo de teste de outra oferta",
                "_links": {
                    "self": {
                        "href": "http://localhost:8080/api/ofertaSelecionada/13"
                    },
                    "ofertaSelecionada": {
                        "href": "http://localhost:8080/api/ofertaSelecionada/13"
                    },
                    "rota": {
                        "href": "http://localhost:8080/api/ofertaSelecionada/13/rota"
                    }
                }
            }
        ]
    },
    "_links": {
        "self": {
            "href": "http://localhost:8080/api/rotas/9/ofertasSelecionada"
        }
    }
}
```
