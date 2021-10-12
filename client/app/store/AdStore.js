Ext.define('client.store.AdsStore', {
    extend: 'Ext.data.Store',

    alias: 'store.adsStore',

    requires: [
        'Ads.model.AdsModel',
        'Ext.data.proxy.Ajax',
        'Ext.data.reader.Json'
    ],

    constructor: function(cfg) {
        var me = this;
        cfg = cfg || {};
        me.callParent([Ext.apply({
            storeId: 'AdsStore',
            autoLoad: true,
            proxy: {
                type: 'ajax',
                url: 'http://localhost:8080/api/ads',
                reader: {
                    type: 'json'
                }
            }
        }, cfg)]);
    }
});
