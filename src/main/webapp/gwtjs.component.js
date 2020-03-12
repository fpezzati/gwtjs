import './gwtjs/gwtjs.nocache.js';
window.customElements.define('effort-component', class EffortComponent extends HTMLElement {
	constructor() {
		super();
		this._shadowRoot = this.attachShadow({ 'mode': 'open' });
	}

	connectedCallback() {
    	console.log('connected!');
    	
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
		this._shadowRoot.appendChild(effortTable);
		effortTable.refresh(model);
    }
});