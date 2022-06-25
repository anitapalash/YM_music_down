var YandexMusicApi = require('yandex-music-api');
var api = new YandexMusicApi();
var scriptor = new Object();

scriptor.getPlaylist = function (a1, a2) {
    response = api.getPlaylist(a1, a2).then(function(playlist) {
          playlist[0].tracks.forEach(function(item) {
              console.log(item.track.title + ' - ' + item.track.artists[0].name);
          });
           console.log(playlist[0]);
          return playlist[0]
        });
       console.log(response);
       res.end(JSON.stringify(response));
};
