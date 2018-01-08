module.exports = function (config) {
    config.set({

        browsers: ['Chrome'],

        files: [
            {
                pattern: 'test-context.js'
            }
        ],

        frameworks: ['jasmine'],

        preprocessors: {
            'test-context.js': ['webpack']
        },

        singleRun: true,

        webpack: {
            module: {
                rules: [
                    {
                        test: /\.js/,
                        exclude: /node_modules/,
                        loader: 'babel-loader'
                    }
                ]
            }
        }
    });
};