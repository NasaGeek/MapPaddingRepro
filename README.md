Reproduction of Android Google Maps centering issue
------------------

I'll add a link to the issue once I've created it.


Building and launching the project without modification should show the error
behavior, which is that the map will not properly center on the location you
tap. I believe this arises from a combination of applying padding to the map
(using GoogleMap::setPadding()) and attempting to zoom to a zoom level that is
less than the minZoomLevel.
