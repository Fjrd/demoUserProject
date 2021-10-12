Ext.define('Ads.model.AdsModel', {
    extends: 'Ext.data.Model',

    requires: [
        'Ext.data.field.String'
    ],

    fields: [
        {
            type: 'string',
            name: 'id'
        },
        {
            type: 'string',
            name: 'status'
        },
        {
            type: 'string',
            name: 'category'
        },
        {
            type: 'string',
            name: 'owner'
            //type
        },
        {
            type: 'string',
            name: 'address'
        },
        {
            type: 'string',
            name: 'text'
        }

    ]

});