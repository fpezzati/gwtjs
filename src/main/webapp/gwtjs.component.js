import './gwtjs/gwtjs.nocache.js';
window.customElements.define('effort-component', class EffortComponent extends HTMLElement {
	constructor() {
		super();
		this._shadowRoot = this.attachShadow({ 'mode': 'open' });
	}

	connectedCallback() {
    	console.log('connected!');
		var effortTable = edu.pezzati.gwtjs.client.provided.EffortTable();
		this._shadowRoot.appendChild(effortTable);
    }
});