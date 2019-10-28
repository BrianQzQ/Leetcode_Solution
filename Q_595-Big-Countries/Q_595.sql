select W.name,W.population,W.area
from World W
where W.area>3000000
Union
select W.name,W.population,W.area
from World W
where W.population>25000000