Ext.define('client.store.UsersStore', {
    extend: 'Ext.data.Store',

    alias: 'store.usersStore',

    requires: [
        'Users.model.UsersModel',
        'Ext.data.proxy.Ajax',
        'Ext.data.reader.Json'
    ],

    constructor: function(cfg) {
        var me = this;
        cfg = cfg || {};
        me.callParent([Ext.apply({
            storeId: 'UsersStore',
            autoLoad: true,
            proxy: {
                type: 'ajax',
                url: 'http://localhost:8080/api/users',
                reader: {
                    type: 'json'
                }
            }
        }, cfg)]);
    }
});
