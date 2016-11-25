<?php
/**
 * Created by IntelliJ IDEA.
 * User: Its
 * Date: 20/11/2016
 * Time: 16:36
 */

include 'GiantBomb.php';
$gb_obj = new GiantBomb("2d03380d725610b0fd52d04058beb84099422441", "json");

$limit = 25;
$offset = 0;
$file_games = 'games.json';
$file_platforms = 'platforms.json';
$file_franchises = 'franchises.json';
$file_genres = 'genres.json';
$file_themes = 'themes.json';
$file_developers = 'developers.json';
$file_publishers = 'publishers.json';

file_put_contents($file_games, "[", LOCK_EX);
file_put_contents($file_platforms, "[", LOCK_EX);
file_put_contents($file_franchises, "[", LOCK_EX);
file_put_contents($file_genres, "[", LOCK_EX);
file_put_contents($file_themes, "[", LOCK_EX);
file_put_contents($file_developers, "[", LOCK_EX);
file_put_contents($file_publishers, "[", LOCK_EX);

$platforms = array();
$franchises = array();
$genres = array();
$themes = array();
$developers = array();
$publishers = array();

$min_user_reviews = 6;
do {

    echo "$offset games parsed.\n";

    $games_ids = $gb_obj->games(array(), $limit, $offset, null, array("number_of_user_reviews"=>"desc"), array("id", "number_of_user_reviews", "name"));
    for ($i = 0; $i < $limit; $i++) {
        //ATENCAO description=deck
        $game_info = $gb_obj->game($games_ids->results[$i]->id, array("id", "name", "deck", "platforms", "franchises", "image", "genres", "themes", "developers", "publishers", "site_detail_url"));

        echo "Parsing game: {$game_info->results->name}.\n";

        if(isset($game_info->results->platforms)) {
            foreach ($game_info->results->platforms as $platform) {
                if (!in_array($platform->id, $platforms)) {
                    array_push($platforms, $platform->id);
                    //TODO chamar platform com o id e escrever em $platforms.json
                    $platform_info = $gb_obj->platform($platform->id, array("id", "name", "deck", "company"));
                    //escreve em $platforms.json
                    $json_string = json_encode($platform_info->results, JSON_PRETTY_PRINT);
                    file_put_contents($file_platforms, ",\n", FILE_APPEND | LOCK_EX);
                    file_put_contents($file_platforms, $json_string, FILE_APPEND | LOCK_EX);
                }
            }
        }

        if(isset($game_info->results->franchises)) {
            foreach ($game_info->results->franchises as $franchise) {
                if (!in_array($franchise->id, $franchises)) {
                    array_push($franchises, $franchise->id);
                    //TODO chamar franchise com o id e escrever em $franchises.json
                    $franchise_info = $gb_obj->franchise($franchise->id, array("id", "name", "deck", "games"));
                    //escreve em $franchise.json
                    $json_string = json_encode($franchise_info->results, JSON_PRETTY_PRINT);
                    file_put_contents($file_franchises, ",\n", FILE_APPEND | LOCK_EX);
                    file_put_contents($file_franchises, $json_string, FILE_APPEND | LOCK_EX);
                }
            }
        }

        if(isset($game_info->results->genres)) {
            foreach ($game_info->results->genres as $genre) {
                if (!in_array($genre->id, $genres)) {
                    array_push($genres, $genre->id);
                    //TODO chamar genre com o id e escrever em $genres.json
                    //escreve em $genres.json
                    $json_string = json_encode($genre, JSON_PRETTY_PRINT);
                    file_put_contents($file_genres, ",\n", FILE_APPEND | LOCK_EX);
                    file_put_contents($file_genres, $json_string, FILE_APPEND | LOCK_EX);
                }
            }
        }

        if(isset($game_info->results->themes)) {
            foreach ($game_info->results->themes as $theme) {
                if (!in_array($theme->id, $themes)) {
                    array_push($themes, $theme->id);
                    //TODO chamar theme com o id e escrever em $themes.json
                    $json_string = json_encode($theme, JSON_PRETTY_PRINT);
                    file_put_contents($file_themes, ",\n", FILE_APPEND | LOCK_EX);
                    file_put_contents($file_themes, $json_string, FILE_APPEND | LOCK_EX);
                }
            }
        }

        if(isset($game_info->results->developers)) {
            foreach ($game_info->results->developers as $developer) {
                if (!in_array($developer->id, $developers)) {
                    array_push($developers, $developer->id);
                    //TODO chamar developer com o id e escrever em $developers.json
                    $developer_info = $gb_obj->company($developer->id, array("id", "name", "deck", "website", "location_country", "developed_games"));
                    //escreve em $file_developers.json
                    $json_string = json_encode($developer_info->results, JSON_PRETTY_PRINT);
                    file_put_contents($file_developers, ",\n", FILE_APPEND | LOCK_EX);
                    file_put_contents($file_developers, $json_string, FILE_APPEND | LOCK_EX);
                }
            }
        }

        if(isset($game_info->results->publishers)) {
            foreach ($game_info->results->publishers as $publisher) {
                if (!in_array($publisher->id, $publishers)) {
                    array_push($publishers, $publisher->id);
                    //TODO chamar publisher com o id e escrever em $publishers.json
                    $publisher_info = $gb_obj->company($publisher->id, array("id", "name", "deck", "website", "location_country", "published_games"));
                    //escreve em $file_developers.json
                    $json_string = json_encode($publisher_info->results, JSON_PRETTY_PRINT);
                    file_put_contents($file_publishers, ",\n", FILE_APPEND | LOCK_EX);
                    file_put_contents($file_publishers, $json_string, FILE_APPEND | LOCK_EX);
                }
            }
        }

        $json_string = json_encode($game_info->results, JSON_PRETTY_PRINT);
        file_put_contents($file_games, ",\n", FILE_APPEND | LOCK_EX);
        file_put_contents($file_games, $json_string, FILE_APPEND | LOCK_EX);
    }
    $offset+=$limit;
    $min_user_reviews = $games_ids->results[$limit-1]->number_of_user_reviews;
} while ($min_user_reviews > 10);

file_put_contents($file_games, "]", FILE_APPEND | LOCK_EX);
file_put_contents($file_platforms, "]", FILE_APPEND | LOCK_EX);
file_put_contents($file_franchises, "]", FILE_APPEND | LOCK_EX);
file_put_contents($file_genres, "]", FILE_APPEND | LOCK_EX);
file_put_contents($file_themes, "]", FILE_APPEND | LOCK_EX);
file_put_contents($file_developers, "]", FILE_APPEND | LOCK_EX);
file_put_contents($file_publishers, "]", FILE_APPEND | LOCK_EX);

/**
$games_results = $games->results;
$json_string = json_encode($games, JSON_PRETTY_PRINT);
echo $json_string;
*/

/**
$file = 'games.json';
file_put_contents($file, $json_string, FILE_APPEND | LOCK_EX);
*/

/**
 * array("original_release_date"=>"desc")
 */

/**
 * $array = array("1" => "PHP code tester Sandbox Online",
    "foo" => "bar", 5 , 5 => 89009,
    "case" => "Random Stuff: " . rand(100,999),
    "PHP Version" => phpversion()
);

foreach( $array as $key => $value ){
    echo $key."\t=>\t".$value."\n";
}
 */

