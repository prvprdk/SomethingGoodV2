const path = require('path');
const {VueLoaderPlugin} = require('vue-loader');
const { VuetifyLoaderPlugin } = require('vuetify-loader')

module.exports = {
 stats: 'errors-only',


  entry: path.join(__dirname, 'src', 'main', 'resources', 'js', 'main.js'),

  module: {
    rules: [

      {
        test: /\.js$/,
        exclude: /(node_modules|bower_components)/,
        use: {
          loader: 'babel-loader',
          options: {
            presets: ['@babel/preset-env']
          }
        }
      },
      {
        test: /\.vue$/,
        loader: 'vue-loader'
      },
      {
         test: /\.css$/,
         use: [
              'vue-style-loader',
              'css-loader',
         ]
      },
      {
         test: /\.s(c|a)ss$/,
         use: [
              'vue-style-loader',
              'css-loader',
          {
            loader: 'sass-loader',
            // Requires >= sass-loader@^8.0.0
            options: {
              implementation: require('sass'),
              sassOptions: {
                indentedSyntax: true // optional
              },
            },
          },
         ]
      }
    ]
  },
  plugins: [
    new VueLoaderPlugin(),
    new VuetifyLoaderPlugin(),
  ],

  resolve: {
      modules: [
          path.join(__dirname, 'src', 'main', 'resources', 'js'),
          path.join(__dirname, 'node_modules'),
      ],
  }
}