var webpack = require('webpack');
var CopyWebpackPlugin = require('copy-webpack-plugin');

module.exports = {
    context: __dirname,

    devtool: "inline-sourcemap",

    entry: "./client",

    output: {
        filename: "index.js",
        path: "./dist"
    },

    module: {
        rules: [
            {
                test: /\.js$/,
                loader: 'babel-loader',
                exclude: /node_modules/,
                query: {
                    presets: ['es2015']
                }
            }
        ],
    },

    plugins: [
        new CopyWebpackPlugin([{
            from: 'client/index.html',
            to: 'index.html',
            force: true
        }, {
            from: 'client/index.css',
            to: 'index.css',
            force: true
        }])
    ],
};
