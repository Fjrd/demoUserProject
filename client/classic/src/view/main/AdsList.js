Ext.define('client.view.main.AdsList', {
    extend: 'Ext.grid.Panel',
    xtype: 'adslist',

    requires: [
        'client.store.AdsStore'
    ],

    title: 'Ads',

    store: {
        type: 'adsStore'
    },

    columns: [
        { text: 'id',  dataIndex: 'id' },
        { text: 'status', dataIndex: 'status', flex: 1 },
        { text: 'category', dataIndex: 'category', flex: 1 },
        { text: 'owner', dataIndex: 'owner', flex: 1 },
        { text: 'address', dataIndex: 'address', flex: 1 },
        { text: 'text', dataIndex: 'text', flex: 1 },
    ],

    listeners: {
        select: 'onItemSelected'
    }
});
