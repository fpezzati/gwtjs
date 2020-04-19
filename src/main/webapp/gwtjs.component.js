//import './gwtjs/gwtjs.nocache.js';

const template = document.createElement('template');
template.innerHTML = `
<button>check</button>
`;

var script = document.createElement("script");
script.src = "./gwtjs/gwtjs.nocache.js";
document.head.appendChild(script);


window.customElements.define('effort-component', class EffortComponent extends HTMLElement {
	constructor() {
		super();
		this._shadowRoot = this.attachShadow({ 'mode': 'open' });
		this._shadowRoot.appendChild(template.content.cloneNode(true));
		this.checkButton = this._shadowRoot.querySelector('button').addEventListener('click', this._initWidget.bind(this));
		this.eventbus = {};
	}
	
	get eventbus() {
		return this.eventbus;
	}
	
	set eventbus(obj) {
		this.eventbus = obj;
	}
	

	connectedCallback() {
    	console.log('connected!');
    	
//    	this._xhr_load('./gwtjs/gwtjs.nocache.js', this, function(ctx, response) {
//    		eval(response);
//    		ctx._initWidget();
//    	});
    	
//    	this._initWidget();
    	
    	window.addEventListener('load', function() {
    		console.log('gwt has finished.');
    	}, false);
    	
    	window.addEventListener('onload', function() {
    		console.log('gwt finished (?) after an onload');
    	});
    }
	
	_initWidget() {
		var actv1 = new edu.pezzati.gwtjs.client.provided.model.Activity;
    	actv1.uuid = "1";
    	actv1.name = "foo";
    	actv1.description = "foo descr";
    	var actv2 = new edu.pezzati.gwtjs.client.provided.model.Activity;
    	actv2.uuid = "2";
    	actv2.name = "bar";
    	actv2.description = "bar descr";
    	
    	var eff1 = new edu.pezzati.gwtjs.client.provided.model.Effort;
    	eff1.uuid = "1";
    	eff1.effortHours = 1;
    	eff1.when = 100;
    	var eff2 = new edu.pezzati.gwtjs.client.provided.model.Effort;
    	eff2.uuid = "2";
    	eff2.effortHours = 2;
    	eff2.when = 200;
    	var eff3 = new edu.pezzati.gwtjs.client.provided.model.Effort;
    	eff3.uuid = "3";
    	eff3.effortHours = 3;
    	eff3.when = 300;
    	var model = [];
    	model[0] = [actv1, actv2];
    	model[1] = [eff1, eff2, eff3];
    	
		var effortTable = edu.pezzati.gwtjs.client.provided.EffortTable();
//		this._shadowRoot.appendChild(effortTable);
		effortTable.refresh(model);
	}
	
	_xhr_load(url, ctx, callback) {
	  var xhr = new XMLHttpRequest();
	  xhr.onreadystatechange = function() {
	    if (xhr.readyState == 4) {
	      if (xhr.status == 200) {
	        callback(ctx, xhr.responseText);
	      } 
	    }
	  }
	  xhr.open("GET", url, true);
	  xhr.send(null);
	}
});