    var express = require('express');
    var app = express();
    var cors = require('cors');
    var bodyParser = require('body-parser');
    var js2xmlparser = require("js2xmlparser");

    app.use(bodyParser.json());
    app.use(bodyParser.urlencoded({ extended: true }));
    app.use(cors());

    app.get('/api/produtos/xml', function (req, res) {
            setTimeout(function(){
                res.set('Content-Type', 'text/xml');
                res.send(js2xmlparser.parse("produtos", 
                            {"produto":[{
                                id: 1,
                                nome: 'Chocolate',
                                categoria: 'doce',
                                descricao: 'Chocolate ao leite'
                            },
                            {
                                id: 2,
                                nome: 'Coxinha',
                                categoria: 'salgado',
                                descricao: 'Massa de mandioca e recheio de frango'
                            },
                            {
                                id: 3,
                                nome: 'suco',
                                categoria: 'bebida',
                                descricao: 'Suco de laranja natural'
                            }]}
                    ));
                res.status(200).end();
            }, 4000);
    });


    app.get('/api/produtos/json', function (req, res) {
            setTimeout(function(){
                res.header('Access-Control-Allow-Origin', '*')
                .send(200,                    
                            [{
                                id: 1,
                                nome: 'Chocolate',
                                categoria: 'doce',
                                descricao: 'Chocolate ao leite com castanhas do Pará',
                                url: 'https://images.tcdn.com.br/img/img_prod/600293/drageado_castanha_do_para_com_chocolate_70_cacau_100g_1183_1_20181115142549.jpg'
                            },
                            {
                                id: 2,
                                nome: 'Coxinha',
                                categoria: 'salgado',
                                descricao: 'Massa de mandioca e recheio de frango',
                                url: 'https://p2.trrsf.com/image/fget/cf/940/0/images.terra.com/2018/09/11/massa-de-coxinha-receita.jpg'
                            },                            
                            {
                                id: 3,
                                nome: 'Suco',
                                categoria: 'bebida',
                                descricao: 'Suco de laranja natural',
                                url: 'https://prolaranja.com.br/wp-content/uploads/2018/09/CopoComLaranja.png'
                            }]                        
                )
            }, 4000);
    });

    app.listen(3000);
    console.log('A API está no ar');