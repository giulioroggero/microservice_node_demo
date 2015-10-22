module.exports = function(grunt) {

  grunt.initConfig({
    jshint: {
      all: ['router/**/*.js','!router/node_modules/**/*.js',
      'services/echo/**/*.js','!services/echo/node_modules/**/*.js',
      'services/hello_world/**/*.js','!services/hello_world/node_modules/**/*.js',
      'services/send_msg/**/*.js','!services/send_msg/node_modules/**/*.js',
      'service_registry/**/*.js','!service_registry/node_modules/**/*.js'],
      options:{
        jshintrc: true
      }
    }
    });
  
  grunt.loadNpmTasks('grunt-contrib-jshint');
  grunt.registerTask('default', ['jshint']);

};
