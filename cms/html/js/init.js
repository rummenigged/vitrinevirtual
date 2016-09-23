window.onload = init;

function loadScript(url, callback) {
    console.info('Carregando ' + url + '...');
    var script = document.createElement('script');
    script.src = url;
    script.addEventListener('load', callback);
    var entrada = document.getElementsByTagName('script')[0];
    entrada.parentNode.appendChild(script);
}

function init() {
    console.info('Iniciando Scripts');
    
//    loadScript('util.js', function () {
//        console.info('util.js Carregado!');
//    });
//    
    
//    loadScript('../js/jquery-1.12.0.min.js', function () {
//        console.info('jquery.js Carregado!');
//    });
     
    loadScript('../js/main.js', function () {
        console.info('main.js Carregado!');
    });
    
    loadScript('../js/util.js', function () {
        console.info('util.js Carregado!');
    });
    
//    loadScript('../materialize/js/materialize.min.js', function () {
//        console.info('materialize.js Carregado!');
//    });
}