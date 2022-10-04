    let express = require('express');
    let app = express();
    let cors = require('cors');
    let bodyParser = require('body-parser');



    data = [  
	{  
		"id": "1",
        "nome":"Pipoca",        		
        "image":"https://i.pinimg.com/originals/b2/21/5c/b2215c404b08d0f0905d693ca55d1708.jpg",        
		"raca":"York Shire"
   	},
   	{	"id": "2",
        "nome":"Rick",
      	"image":"https://upload.wikimedia.org/wikipedia/commons/2/27/2._DSC_0346_%2810096362833%292.jpg",
      	"raca":"Pastor Alemão"
   	},
   	{  	"id": "3",
        "nome":"Lexy",
		"image":"https://www.universodoaquario.com.br/image/cache/catalog/filhotes/cao-raca-maltes-900x900.jpeg",
		"raca":"Maltês"
   	},
   	{   "id": "4",
        "nome":"Gigi",
	    "image":"https://i.pinimg.com/originals/4e/e6/d5/4ee6d5eb4079c9db7dc17074d3073c23.jpg",
  		"raca":"Schnowser"
	},   	
	];


    app.use(bodyParser.json());
    app.use(bodyParser.urlencoded({ extended: true }));
    app.use(cors());

    app.get('/api/dog/get', function (req, res) {
        setTimeout(function(){
        res.header('Access-Control-Allow-Origin', '*')
        .send(200,data
    )
    }, 3000);
    });


    app.get('/api/dog/getNome/:nome', (req, res) => {
        const nome = req.params.nome;
        const item = data.find(item => item.nome == nome);
        return res.json(item);
    });

    app.post('/api/dog/post', (req, res) => {
        const id = req.body.id;
        const nome = req.body.nome;
        const raca = req.body.raca;        
        const image = req.body.image;
        return res.json({id,nome,raca,image});
    });

    app.put('/api/dog/put/:id', (req, res) => {
        const id = req.params.id;
        const item = data.find(item => item.id == id);        
        item.nome = req.body.nome;
        item.raca = req.body.raca;
        item.imagem = req.body.imagem;
        return res.json(item);
    });

    app.get('/api/dog/delete/:id', (req, res) => {
        const id = req.params.id;
        const item = data.find(item => item.id == id);
        return res.json(item);
    });

    app.listen(3000);
    console.log('A API está no ar');