var EventBus = {
  handler: new Array,
  subscribe: function(actionHandler) {
    this.handler[actionHandler.type] = actionHandler;
  },
  publish: function(action) {
    if(this.handler[action.type]) {
      this.handler[action.type].handle(action);
    } else {
      console.log("EventBus> can not handle action type: " + action.type);
    }
  }
};
export default EventBus;
