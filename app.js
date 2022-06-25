var greeting = 'hello world!';
console.log(greeting);

var YandexMusicApi = require('yandex-music-api');

var api = new YandexMusicApi();

const list = api.getPlaylist('anitapalash', 1039).then(function(playlist) {

       playlist[0].tracks.forEach(function(item) {
           console.log(item.track.title + ' - ' + item.track.artists[0].name);
       });
        console.log(playlist[0]);
       return playlist[0]
});
