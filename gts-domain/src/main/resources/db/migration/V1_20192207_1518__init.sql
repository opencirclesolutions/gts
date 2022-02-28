CREATE TABLE domain
(
	id                   SERIAL NOT NULL,
	code                 VARCHAR(3) NULL,
	type                 VARCHAR(20) NOT NULL,
	name                 VARCHAR(255) NOT NULL,
	parent               INTEGER NULL,
	version              INTEGER NULL,
	PRIMARY KEY (Id)
);


CREATE INDEX domain_idx1 ON Domain
(
	parent
);

CREATE UNIQUE INDEX domain_idx2 ON Domain
(
	type,code
);

CREATE UNIQUE INDEX domain_idx3 ON Domain
(
	type,name
);

insert into Domain(code, name, type,version) values('EUR','Europe','REGION', 0);
insert into Domain(code, name, type,version) values('AFR','Africa','REGION', 0);
insert into Domain(code, name, type,version) values('ASI','Asia','REGION', 0);
insert into Domain(code, name, type,version) values('AUS','Australia','REGION', 0);
insert into Domain(code, name, type,version) values('NAM','North America','REGION', 0);
insert into Domain(code, name, type,version) values('SAM','South America','REGION', 0);
insert into Domain(code, name, type,version) values('ANT','Antarctica','REGION', 0);
insert into Domain(code, name, type,version) values('WOW','Worldwide','REGION', 0);
insert into Domain(code, name, type,version) values('UNK','Unknown','REGION', 0);

insert into Domain(code, name, type,parent,version) values('AFG','Afghanistan','COUNTRY', (select id from domain where type = 'REGION' and code = 'ASI'), 0);
insert into Domain(code, name, type,parent,version) values('ALA','Åland Islands','COUNTRY', (select id from domain where type = 'REGION' and code = 'EUR'), 0);
insert into Domain(code, name, type,parent,version) values('ALB','Albania','COUNTRY', (select id from domain where type = 'REGION' and code = 'EUR'), 0);
insert into Domain(code, name, type,parent,version) values('DZA','Algeria','COUNTRY', (select id from domain where type = 'REGION' and code = 'AFR'), 0);
insert into Domain(code, name, type,parent,version) values('ASM','American Samoa','COUNTRY', (select id from domain where type = 'REGION' and code = 'AUS'), 0);
insert into Domain(code, name, type,parent,version) values('AND','Andorra','COUNTRY', (select id from domain where type = 'REGION' and code = 'EUR'), 0);
insert into Domain(code, name, type,parent,version) values('AGO','Angola','COUNTRY', (select id from domain where type = 'REGION' and code = 'AFR'), 0);
insert into Domain(code, name, type,parent,version) values('AIA','Anguilla','COUNTRY', (select id from domain where type = 'REGION' and code = 'NAM'), 0);
insert into Domain(code, name, type,parent,version) values('ATA','Antarctica','COUNTRY', (select id from domain where type = 'REGION' and code = 'ANT'), 0);
insert into Domain(code, name, type,parent,version) values('ATG','Antigua and Barbuda','COUNTRY', (select id from domain where type = 'REGION' and code = 'NAM'), 0);
insert into Domain(code, name, type,parent,version) values('ARG','Argentina','COUNTRY', (select id from domain where type = 'REGION' and code = 'SAM'), 0);
insert into Domain(code, name, type,parent,version) values('ARM','Armenia','COUNTRY', (select id from domain where type = 'REGION' and code = 'EUR'), 0);
insert into Domain(code, name, type,parent,version) values('ABW','Aruba','COUNTRY', (select id from domain where type = 'REGION' and code = 'NAM'), 0);
insert into Domain(code, name, type,parent,version) values('AUS','Australia','COUNTRY', (select id from domain where type = 'REGION' and code = 'AUS'), 0);
insert into Domain(code, name, type,parent,version) values('AUT','Austria','COUNTRY', (select id from domain where type = 'REGION' and code = 'EUR'), 0);
insert into Domain(code, name, type,parent,version) values('AZE','Azerbaijan','COUNTRY', (select id from domain where type = 'REGION' and code = 'EUR'), 0);
insert into Domain(code, name, type,parent,version) values('BHS','Bahamas','COUNTRY', (select id from domain where type = 'REGION' and code = 'NAM'), 0);
insert into Domain(code, name, type,parent,version) values('BHR','Bahrain','COUNTRY', (select id from domain where type = 'REGION' and code = 'ASI'), 0);
insert into Domain(code, name, type,parent,version) values('BGD','Bangladesh','COUNTRY', (select id from domain where type = 'REGION' and code = 'ASI'), 0);
insert into Domain(code, name, type,parent,version) values('BRB','Barbados','COUNTRY', (select id from domain where type = 'REGION' and code = 'NAM'), 0);
insert into Domain(code, name, type,parent,version) values('BLR','Belarus','COUNTRY', (select id from domain where type = 'REGION' and code = 'EUR'), 0);
insert into Domain(code, name, type,parent,version) values('BEL','Belgium','COUNTRY', (select id from domain where type = 'REGION' and code = 'EUR'), 0);
insert into Domain(code, name, type,parent,version) values('BLZ','Belize','COUNTRY', (select id from domain where type = 'REGION' and code = 'NAM'), 0);
insert into Domain(code, name, type,parent,version) values('BEN','Benin','COUNTRY', (select id from domain where type = 'REGION' and code = 'AFR'), 0);
insert into Domain(code, name, type,parent,version) values('BMU','Bermuda','COUNTRY', (select id from domain where type = 'REGION' and code = 'NAM'), 0);
insert into Domain(code, name, type,parent,version) values('BTN','Bhutan','COUNTRY', (select id from domain where type = 'REGION' and code = 'ASI'), 0);
insert into Domain(code, name, type,parent,version) values('BOL','Bolivia','COUNTRY', (select id from domain where type = 'REGION' and code = 'SAM'), 0);
insert into Domain(code, name, type,parent,version) values('BES','Bonaire, Sint Eustatius and Saba','COUNTRY', (select id from domain where type = 'REGION' and code = 'NAM'), 0);
insert into Domain(code, name, type,parent,version) values('BIH','Bosnia and Herzegovina','COUNTRY', (select id from domain where type = 'REGION' and code = 'EUR'), 0);
insert into Domain(code, name, type,parent,version) values('BWA','Botswana','COUNTRY', (select id from domain where type = 'REGION' and code = 'AFR'), 0);
insert into Domain(code, name, type,parent,version) values('BVT','Bouvet Island','COUNTRY', (select id from domain where type = 'REGION' and code = 'ANT'), 0);
insert into Domain(code, name, type,parent,version) values('BRA','Brazil','COUNTRY', (select id from domain where type = 'REGION' and code = 'SAM'), 0);
insert into Domain(code, name, type,parent,version) values('IOT','British Indian Ocean Territory ','COUNTRY', (select id from domain where type = 'REGION' and code = 'AUS'), 0);
insert into Domain(code, name, type,parent,version) values('BRN','Brunei Darussalam','COUNTRY', (select id from domain where type = 'REGION' and code = 'ASI'), 0);
insert into Domain(code, name, type,parent,version) values('BGR','Bulgaria','COUNTRY', (select id from domain where type = 'REGION' and code = 'EUR'), 0);
insert into Domain(code, name, type,parent,version) values('BFA','Burkina Faso','COUNTRY', (select id from domain where type = 'REGION' and code = 'AFR'), 0);
insert into Domain(code, name, type,parent,version) values('BDI','Burundi','COUNTRY', (select id from domain where type = 'REGION' and code = 'AFR'), 0);
insert into Domain(code, name, type,parent,version) values('CPV','Cabo Verde','COUNTRY', (select id from domain where type = 'REGION' and code = 'AFR'), 0);
insert into Domain(code, name, type,parent,version) values('KHM','Cambodia','COUNTRY', (select id from domain where type = 'REGION' and code = 'ASI'), 0);
insert into Domain(code, name, type,parent,version) values('CMR','Cameroon','COUNTRY', (select id from domain where type = 'REGION' and code = 'AFR'), 0);
insert into Domain(code, name, type,parent,version) values('CAN','Canada','COUNTRY', (select id from domain where type = 'REGION' and code = 'NAM'), 0);
insert into Domain(code, name, type,parent,version) values('CYM','Cayman Islands','COUNTRY', (select id from domain where type = 'REGION' and code = 'NAM'), 0);
insert into Domain(code, name, type,parent,version) values('CAF','Central African Republic','COUNTRY', (select id from domain where type = 'REGION' and code = 'AFR'), 0);
insert into Domain(code, name, type,parent,version) values('TCD','Chad','COUNTRY', (select id from domain where type = 'REGION' and code = 'AFR'), 0);
insert into Domain(code, name, type,parent,version) values('CHL','Chile','COUNTRY', (select id from domain where type = 'REGION' and code = 'SAM'), 0);
insert into Domain(code, name, type,parent,version) values('CHN','China','COUNTRY', (select id from domain where type = 'REGION' and code = 'ASI'), 0);
insert into Domain(code, name, type,parent,version) values('CXR','Christmas Island','COUNTRY', (select id from domain where type = 'REGION' and code = 'AUS'), 0);
insert into Domain(code, name, type,parent,version) values('CCK','Cocos (Keeling) Islands','COUNTRY', (select id from domain where type = 'REGION' and code = 'AUS'), 0);
insert into Domain(code, name, type,parent,version) values('COL','Colombia','COUNTRY', (select id from domain where type = 'REGION' and code = 'SAM'), 0);
insert into Domain(code, name, type,parent,version) values('COM','Comoros','COUNTRY', (select id from domain where type = 'REGION' and code = 'AFR'), 0);
insert into Domain(code, name, type,parent,version) values('COD','Congo (the Democratic Republic of the)','COUNTRY', (select id from domain where type = 'REGION' and code = 'AFR'), 0);
insert into Domain(code, name, type,parent,version) values('COG','Congo ','COUNTRY', (select id from domain where type = 'REGION' and code = 'AFR'), 0);
insert into Domain(code, name, type,parent,version) values('COK','Cook Islands','COUNTRY', (select id from domain where type = 'REGION' and code = 'AUS'), 0);
insert into Domain(code, name, type,parent,version) values('CRI','Costa Rica','COUNTRY', (select id from domain where type = 'REGION' and code = 'NAM'), 0);
insert into Domain(code, name, type,parent,version) values('CIV','Côte d''Ivoire','COUNTRY', (select id from domain where type = 'REGION' and code = 'AFR'), 0);
insert into Domain(code, name, type,parent,version) values('HRV','Croatia','COUNTRY', (select id from domain where type = 'REGION' and code = 'EUR'), 0);
insert into Domain(code, name, type,parent,version) values('CUB','Cuba','COUNTRY', (select id from domain where type = 'REGION' and code = 'NAM'), 0);
insert into Domain(code, name, type,parent,version) values('CUW','Curaçao','COUNTRY', (select id from domain where type = 'REGION' and code = 'NAM'), 0);
insert into Domain(code, name, type,parent,version) values('CYP','Cyprus','COUNTRY', (select id from domain where type = 'REGION' and code = 'EUR'), 0);
insert into Domain(code, name, type,parent,version) values('CZE','Czech Republic','COUNTRY', (select id from domain where type = 'REGION' and code = 'EUR'), 0);
insert into Domain(code, name, type,parent,version) values('DNK','Denmark','COUNTRY', (select id from domain where type = 'REGION' and code = 'EUR'), 0);
insert into Domain(code, name, type,parent,version) values('DJI','Djibouti','COUNTRY', (select id from domain where type = 'REGION' and code = 'AFR'), 0);
insert into Domain(code, name, type,parent,version) values('DMA','Dominica','COUNTRY', (select id from domain where type = 'REGION' and code = ''), 0);
insert into Domain(code, name, type,parent,version) values('DOM','Dominican Republic','COUNTRY', (select id from domain where type = 'REGION' and code = 'NAM'), 0);
insert into Domain(code, name, type,parent,version) values('ECU','Ecuador','COUNTRY', (select id from domain where type = 'REGION' and code = 'SAM'), 0);
insert into Domain(code, name, type,parent,version) values('EGY','Egypt','COUNTRY', (select id from domain where type = 'REGION' and code = 'AFR'), 0);
insert into Domain(code, name, type,parent,version) values('SLV','El Salvador','COUNTRY', (select id from domain where type = 'REGION' and code = 'NAM'), 0);
insert into Domain(code, name, type,parent,version) values('GNQ','Equatorial Guinea','COUNTRY', (select id from domain where type = 'REGION' and code = 'AFR'), 0);
insert into Domain(code, name, type,parent,version) values('ERI','Eritrea','COUNTRY', (select id from domain where type = 'REGION' and code = 'AFR'), 0);
insert into Domain(code, name, type,parent,version) values('EST','Estonia','COUNTRY', (select id from domain where type = 'REGION' and code = 'EUR'), 0);
insert into Domain(code, name, type,parent,version) values('ETH','Ethiopia','COUNTRY', (select id from domain where type = 'REGION' and code = 'AFR'), 0);
insert into Domain(code, name, type,parent,version) values('FLK','Falkland Islands  [Malvinas]','COUNTRY', (select id from domain where type = 'REGION' and code = 'SAM'), 0);
insert into Domain(code, name, type,parent,version) values('FRO','Faroe Islands ','COUNTRY', (select id from domain where type = 'REGION' and code = 'EUR'), 0);
insert into Domain(code, name, type,parent,version) values('FJI','Fiji','COUNTRY', (select id from domain where type = 'REGION' and code = 'AUS'), 0);
insert into Domain(code, name, type,parent,version) values('FIN','Finland','COUNTRY', (select id from domain where type = 'REGION' and code = 'EUR'), 0);
insert into Domain(code, name, type,parent,version) values('FRA','France','COUNTRY', (select id from domain where type = 'REGION' and code = 'EUR'), 0);
insert into Domain(code, name, type,parent,version) values('GUF','French Guiana','COUNTRY', (select id from domain where type = 'REGION' and code = 'SAM'), 0);
insert into Domain(code, name, type,parent,version) values('PYF','French Polynesia','COUNTRY', (select id from domain where type = 'REGION' and code = 'AUS'), 0);
insert into Domain(code, name, type,parent,version) values('ATF','French Southern Territories ','COUNTRY', (select id from domain where type = 'REGION' and code = 'AUS'), 0);
insert into Domain(code, name, type,parent,version) values('GAB','Gabon','COUNTRY', (select id from domain where type = 'REGION' and code = 'AFR'), 0);
insert into Domain(code, name, type,parent,version) values('GMB','Gambia ','COUNTRY', (select id from domain where type = 'REGION' and code = 'AFR'), 0);
insert into Domain(code, name, type,parent,version) values('GEO','Georgia','COUNTRY', (select id from domain where type = 'REGION' and code = 'EUR'), 0);
insert into Domain(code, name, type,parent,version) values('DEU','Germany','COUNTRY', (select id from domain where type = 'REGION' and code = 'EUR'), 0);
insert into Domain(code, name, type,parent,version) values('GHA','Ghana','COUNTRY', (select id from domain where type = 'REGION' and code = 'AFR'), 0);
insert into Domain(code, name, type,parent,version) values('GIB','Gibraltar','COUNTRY', (select id from domain where type = 'REGION' and code = 'EUR'), 0);
insert into Domain(code, name, type,parent,version) values('GRC','Greece','COUNTRY', (select id from domain where type = 'REGION' and code = 'EUR'), 0);
insert into Domain(code, name, type,parent,version) values('GRL','Greenland','COUNTRY', (select id from domain where type = 'REGION' and code = 'EUR'), 0);
insert into Domain(code, name, type,parent,version) values('GRD','Grenada','COUNTRY', (select id from domain where type = 'REGION' and code = 'NAM'), 0);
insert into Domain(code, name, type,parent,version) values('GLP','Guadeloupe','COUNTRY', (select id from domain where type = 'REGION' and code = 'NAM'), 0);
insert into Domain(code, name, type,parent,version) values('GUM','Guam','COUNTRY', (select id from domain where type = 'REGION' and code = 'AUS'), 0);
insert into Domain(code, name, type,parent,version) values('GTM','Guatemala','COUNTRY', (select id from domain where type = 'REGION' and code = 'NAM'), 0);
insert into Domain(code, name, type,parent,version) values('GGY','Guernsey','COUNTRY', (select id from domain where type = 'REGION' and code = 'EUR'), 0);
insert into Domain(code, name, type,parent,version) values('GIN','Guinea','COUNTRY', (select id from domain where type = 'REGION' and code = 'AFR'), 0);
insert into Domain(code, name, type,parent,version) values('GNB','Guinea-Bissau','COUNTRY', (select id from domain where type = 'REGION' and code = 'AFR'), 0);
insert into Domain(code, name, type,parent,version) values('GUY','Guyana','COUNTRY', (select id from domain where type = 'REGION' and code = 'SAM'), 0);
insert into Domain(code, name, type,parent,version) values('HTI','Haiti','COUNTRY', (select id from domain where type = 'REGION' and code = 'NAM'), 0);
insert into Domain(code, name, type,parent,version) values('HMD','Heard Island and McDonald Islands','COUNTRY', (select id from domain where type = 'REGION' and code = 'AUS'), 0);
insert into Domain(code, name, type,parent,version) values('VAT','Holy See ','COUNTRY', (select id from domain where type = 'REGION' and code = 'EUR'), 0);
insert into Domain(code, name, type,parent,version) values('HND','Honduras','COUNTRY', (select id from domain where type = 'REGION' and code = 'NAM'), 0);
insert into Domain(code, name, type,parent,version) values('HKG','Hong Kong','COUNTRY', (select id from domain where type = 'REGION' and code = 'ASI'), 0);
insert into Domain(code, name, type,parent,version) values('HUN','Hungary','COUNTRY', (select id from domain where type = 'REGION' and code = 'EUR'), 0);
insert into Domain(code, name, type,parent,version) values('ISL','Iceland','COUNTRY', (select id from domain where type = 'REGION' and code = 'EUR'), 0);
insert into Domain(code, name, type,parent,version) values('IND','India','COUNTRY', (select id from domain where type = 'REGION' and code = 'ASI'), 0);
insert into Domain(code, name, type,parent,version) values('IDN','Indonesia','COUNTRY', (select id from domain where type = 'REGION' and code = 'ASI'), 0);
insert into Domain(code, name, type,parent,version) values('IRN','Iran (Islamic Republic of)','COUNTRY', (select id from domain where type = 'REGION' and code = 'ASI'), 0);
insert into Domain(code, name, type,parent,version) values('IRQ','Iraq','COUNTRY', (select id from domain where type = 'REGION' and code = 'ASI'), 0);
insert into Domain(code, name, type,parent,version) values('IRL','Ireland','COUNTRY', (select id from domain where type = 'REGION' and code = 'EUR'), 0);
insert into Domain(code, name, type,parent,version) values('IMN','Isle of Man','COUNTRY', (select id from domain where type = 'REGION' and code = 'EUR'), 0);
insert into Domain(code, name, type,parent,version) values('ISR','Israel','COUNTRY', (select id from domain where type = 'REGION' and code = 'ASI'), 0);
insert into Domain(code, name, type,parent,version) values('ITA','Italy','COUNTRY', (select id from domain where type = 'REGION' and code = 'EUR'), 0);
insert into Domain(code, name, type,parent,version) values('JAM','Jamaica','COUNTRY', (select id from domain where type = 'REGION' and code = 'NAM'), 0);
insert into Domain(code, name, type,parent,version) values('JPN','Japan','COUNTRY', (select id from domain where type = 'REGION' and code = 'ASI'), 0);
insert into Domain(code, name, type,parent,version) values('JEY','Jersey','COUNTRY', (select id from domain where type = 'REGION' and code = 'EUR'), 0);
insert into Domain(code, name, type,parent,version) values('JOR','Jordan','COUNTRY', (select id from domain where type = 'REGION' and code = 'ASI'), 0);
insert into Domain(code, name, type,parent,version) values('KAZ','Kazakhstan','COUNTRY', (select id from domain where type = 'REGION' and code = 'EUR'), 0);
insert into Domain(code, name, type,parent,version) values('KEN','Kenya','COUNTRY', (select id from domain where type = 'REGION' and code = 'AFR'), 0);
insert into Domain(code, name, type,parent,version) values('KIR','Kiribati','COUNTRY', (select id from domain where type = 'REGION' and code = 'ASI'), 0);
insert into Domain(code, name, type,parent,version) values('PRK','Korea (the Democratic People''s Republic of)','COUNTRY', (select id from domain where type = 'REGION' and code = 'ASI'), 0);
insert into Domain(code, name, type,parent,version) values('KOR','Korea (the Republic of)','COUNTRY', (select id from domain where type = 'REGION' and code = 'ASI'), 0);
insert into Domain(code, name, type,parent,version) values('KWT','Kuwait','COUNTRY', (select id from domain where type = 'REGION' and code = 'ASI'), 0);
insert into Domain(code, name, type,parent,version) values('KGZ','Kyrgyzstan','COUNTRY', (select id from domain where type = 'REGION' and code = 'ASI'), 0);
insert into Domain(code, name, type,parent,version) values('LAO','Lao People''s Democratic Republic ','COUNTRY', (select id from domain where type = 'REGION' and code = 'ASI'), 0);
insert into Domain(code, name, type,parent,version) values('LVA','Latvia','COUNTRY', (select id from domain where type = 'REGION' and code = 'EUR'), 0);
insert into Domain(code, name, type,parent,version) values('LBN','Lebanon','COUNTRY', (select id from domain where type = 'REGION' and code = 'ASI'), 0);
insert into Domain(code, name, type,parent,version) values('LSO','Lesotho','COUNTRY', (select id from domain where type = 'REGION' and code = 'AFR'), 0);
insert into Domain(code, name, type,parent,version) values('LBR','Liberia','COUNTRY', (select id from domain where type = 'REGION' and code = 'AFR'), 0);
insert into Domain(code, name, type,parent,version) values('LBY','Libya','COUNTRY', (select id from domain where type = 'REGION' and code = 'AFR'), 0);
insert into Domain(code, name, type,parent,version) values('LIE','Liechtenstein','COUNTRY', (select id from domain where type = 'REGION' and code = 'EUR'), 0);
insert into Domain(code, name, type,parent,version) values('LTU','Lithuania','COUNTRY', (select id from domain where type = 'REGION' and code = 'EUR'), 0);
insert into Domain(code, name, type,parent,version) values('LUX','Luxembourg','COUNTRY', (select id from domain where type = 'REGION' and code = 'EUR'), 0);
insert into Domain(code, name, type,parent,version) values('MAC','Macao','COUNTRY', (select id from domain where type = 'REGION' and code = 'ASI'), 0);
insert into Domain(code, name, type,parent,version) values('MKD','Macedonia (the former Yugoslav Republic of)','COUNTRY', (select id from domain where type = 'REGION' and code = 'EUR'), 0);
insert into Domain(code, name, type,parent,version) values('MDG','Madagascar','COUNTRY', (select id from domain where type = 'REGION' and code = 'AFR'), 0);
insert into Domain(code, name, type,parent,version) values('MWI','Malawi','COUNTRY', (select id from domain where type = 'REGION' and code = 'AFR'), 0);
insert into Domain(code, name, type,parent,version) values('MYS','Malaysia','COUNTRY', (select id from domain where type = 'REGION' and code = 'ASI'), 0);
insert into Domain(code, name, type,parent,version) values('MDV','Maldives','COUNTRY', (select id from domain where type = 'REGION' and code = 'ASI'), 0);
insert into Domain(code, name, type,parent,version) values('MLI','Mali','COUNTRY', (select id from domain where type = 'REGION' and code = 'AFR'), 0);
insert into Domain(code, name, type,parent,version) values('MLT','Malta','COUNTRY', (select id from domain where type = 'REGION' and code = 'EUR'), 0);
insert into Domain(code, name, type,parent,version) values('MHL','Marshall Islands ','COUNTRY', (select id from domain where type = 'REGION' and code = 'AUS'), 0);
insert into Domain(code, name, type,parent,version) values('MTQ','Martinique','COUNTRY', (select id from domain where type = 'REGION' and code = 'NAM'), 0);
insert into Domain(code, name, type,parent,version) values('MRT','Mauritania','COUNTRY', (select id from domain where type = 'REGION' and code = 'AFR'), 0);
insert into Domain(code, name, type,parent,version) values('MUS','Mauritius','COUNTRY', (select id from domain where type = 'REGION' and code = 'AFR'), 0);
insert into Domain(code, name, type,parent,version) values('MYT','Mayotte','COUNTRY', (select id from domain where type = 'REGION' and code = 'AFR'), 0);
insert into Domain(code, name, type,parent,version) values('MEX','Mexico','COUNTRY', (select id from domain where type = 'REGION' and code = 'NAM'), 0);
insert into Domain(code, name, type,parent,version) values('FSM','Micronesia (Federated States of)','COUNTRY', (select id from domain where type = 'REGION' and code = 'AUS'), 0);
insert into Domain(code, name, type,parent,version) values('MDA','Moldova (the Republic of)','COUNTRY', (select id from domain where type = 'REGION' and code = 'EUR'), 0);
insert into Domain(code, name, type,parent,version) values('MCO','Monaco','COUNTRY', (select id from domain where type = 'REGION' and code = 'EUR'), 0);
insert into Domain(code, name, type,parent,version) values('MNG','Mongolia','COUNTRY', (select id from domain where type = 'REGION' and code = 'ASI'), 0);
insert into Domain(code, name, type,parent,version) values('MNE','Montenegro','COUNTRY', (select id from domain where type = 'REGION' and code = 'EUR'), 0);
insert into Domain(code, name, type,parent,version) values('MSR','Montserrat','COUNTRY', (select id from domain where type = 'REGION' and code = 'NAM'), 0);
insert into Domain(code, name, type,parent,version) values('MAR','Morocco','COUNTRY', (select id from domain where type = 'REGION' and code = 'AFR'), 0);
insert into Domain(code, name, type,parent,version) values('MOZ','Mozambique','COUNTRY', (select id from domain where type = 'REGION' and code = 'AFR'), 0);
insert into Domain(code, name, type,parent,version) values('MMR','Myanmar','COUNTRY', (select id from domain where type = 'REGION' and code = 'ASI'), 0);
insert into Domain(code, name, type,parent,version) values('NAM','Namibia','COUNTRY', (select id from domain where type = 'REGION' and code = 'AFR'), 0);
insert into Domain(code, name, type,parent,version) values('NRU','Nauru','COUNTRY', (select id from domain where type = 'REGION' and code = 'AUS'), 0);
insert into Domain(code, name, type,parent,version) values('NPL','Nepal','COUNTRY', (select id from domain where type = 'REGION' and code = 'ASI'), 0);
insert into Domain(code, name, type,parent,version) values('NLD','Netherlands','COUNTRY', (select id from domain where type = 'REGION' and code = 'EUR'), 0);
insert into Domain(code, name, type,parent,version) values('NCL','New Caledonia','COUNTRY', (select id from domain where type = 'REGION' and code = 'AUS'), 0);
insert into Domain(code, name, type,parent,version) values('NZL','New Zealand','COUNTRY', (select id from domain where type = 'REGION' and code = 'AUS'), 0);
insert into Domain(code, name, type,parent,version) values('NIC','Nicaragua','COUNTRY', (select id from domain where type = 'REGION' and code = 'NAM'), 0);
insert into Domain(code, name, type,parent,version) values('NER','Niger ','COUNTRY', (select id from domain where type = 'REGION' and code = 'AFR'), 0);
insert into Domain(code, name, type,parent,version) values('NGA','Nigeria','COUNTRY', (select id from domain where type = 'REGION' and code = 'AFR'), 0);
insert into Domain(code, name, type,parent,version) values('NIU','Niue','COUNTRY', (select id from domain where type = 'REGION' and code = 'ASI'), 0);
insert into Domain(code, name, type,parent,version) values('NFK','Norfolk Island','COUNTRY', (select id from domain where type = 'REGION' and code = 'AUS'), 0);
insert into Domain(code, name, type,parent,version) values('MNP','Northern Mariana Islands ','COUNTRY', (select id from domain where type = 'REGION' and code = 'AUS'), 0);
insert into Domain(code, name, type,parent,version) values('NOR','Norway','COUNTRY', (select id from domain where type = 'REGION' and code = 'EUR'), 0);
insert into Domain(code, name, type,parent,version) values('OMN','Oman','COUNTRY', (select id from domain where type = 'REGION' and code = 'ASI'), 0);
insert into Domain(code, name, type,parent,version) values('PAK','Pakistan','COUNTRY', (select id from domain where type = 'REGION' and code = 'ASI'), 0);
insert into Domain(code, name, type,parent,version) values('PLW','Palau','COUNTRY', (select id from domain where type = 'REGION' and code = 'AUS'), 0);
insert into Domain(code, name, type,parent,version) values('PSE','Palestine, State of','COUNTRY', (select id from domain where type = 'REGION' and code = 'ASI'), 0);
insert into Domain(code, name, type,parent,version) values('PAN','Panama','COUNTRY', (select id from domain where type = 'REGION' and code = 'NAM'), 0);
insert into Domain(code, name, type,parent,version) values('PNG','Papua New Guinea','COUNTRY', (select id from domain where type = 'REGION' and code = 'AUS'), 0);
insert into Domain(code, name, type,parent,version) values('PRY','Paraguay','COUNTRY', (select id from domain where type = 'REGION' and code = 'SAM'), 0);
insert into Domain(code, name, type,parent,version) values('PER','Peru','COUNTRY', (select id from domain where type = 'REGION' and code = 'SAM'), 0);
insert into Domain(code, name, type,parent,version) values('PHL','Philippines ','COUNTRY', (select id from domain where type = 'REGION' and code = 'ASI'), 0);
insert into Domain(code, name, type,parent,version) values('PCN','Pitcairn','COUNTRY', (select id from domain where type = 'REGION' and code = 'AUS'), 0);
insert into Domain(code, name, type,parent,version) values('POL','Poland','COUNTRY', (select id from domain where type = 'REGION' and code = 'EUR'), 0);
insert into Domain(code, name, type,parent,version) values('PRT','Portugal','COUNTRY', (select id from domain where type = 'REGION' and code = 'EUR'), 0);
insert into Domain(code, name, type,parent,version) values('PRI','Puerto Rico','COUNTRY', (select id from domain where type = 'REGION' and code = 'NAM'), 0);
insert into Domain(code, name, type,parent,version) values('QAT','Qatar','COUNTRY', (select id from domain where type = 'REGION' and code = 'ASI'), 0);
insert into Domain(code, name, type,parent,version) values('REU','Réunion','COUNTRY', (select id from domain where type = 'REGION' and code = 'AFR'), 0);
insert into Domain(code, name, type,parent,version) values('ROU','Romania','COUNTRY', (select id from domain where type = 'REGION' and code = 'EUR'), 0);
insert into Domain(code, name, type,parent,version) values('RUS','Russian Federation ','COUNTRY', (select id from domain where type = 'REGION' and code = 'EUR'), 0);
insert into Domain(code, name, type,parent,version) values('RWA','Rwanda','COUNTRY', (select id from domain where type = 'REGION' and code = 'AFR'), 0);
insert into Domain(code, name, type,parent,version) values('BLM','Saint Barthélemy','COUNTRY', (select id from domain where type = 'REGION' and code = 'NAM'), 0);
insert into Domain(code, name, type,parent,version) values('SHN','Saint Helena, Ascension and Tristan da Cunha','COUNTRY', (select id from domain where type = 'REGION' and code = 'AFR'), 0);
insert into Domain(code, name, type,parent,version) values('KNA','Saint Kitts and Nevis','COUNTRY', (select id from domain where type = 'REGION' and code = 'NAM'), 0);
insert into Domain(code, name, type,parent,version) values('LCA','Saint Lucia','COUNTRY', (select id from domain where type = 'REGION' and code = 'NAM'), 0);
insert into Domain(code, name, type,parent,version) values('MAF','Saint Martin (French part)','COUNTRY', (select id from domain where type = 'REGION' and code = 'NAM'), 0);
insert into Domain(code, name, type,parent,version) values('SPM','Saint Pierre and Miquelon','COUNTRY', (select id from domain where type = 'REGION' and code = 'NAM'), 0);
insert into Domain(code, name, type,parent,version) values('VCT','Saint Vincent and the Grenadines','COUNTRY', (select id from domain where type = 'REGION' and code = 'NAM'), 0);
insert into Domain(code, name, type,parent,version) values('WSM','Samoa','COUNTRY', (select id from domain where type = 'REGION' and code = 'AUS'), 0);
insert into Domain(code, name, type,parent,version) values('SMR','San Marino','COUNTRY', (select id from domain where type = 'REGION' and code = 'EUR'), 0);
insert into Domain(code, name, type,parent,version) values('STP','Sao Tome and Principe','COUNTRY', (select id from domain where type = 'REGION' and code = 'NAM'), 0);
insert into Domain(code, name, type,parent,version) values('SAU','Saudi Arabia','COUNTRY', (select id from domain where type = 'REGION' and code = 'ASI'), 0);
insert into Domain(code, name, type,parent,version) values('SEN','Senegal','COUNTRY', (select id from domain where type = 'REGION' and code = 'AFR'), 0);
insert into Domain(code, name, type,parent,version) values('SRB','Serbia','COUNTRY', (select id from domain where type = 'REGION' and code = 'EUR'), 0);
insert into Domain(code, name, type,parent,version) values('SYC','Seychelles','COUNTRY', (select id from domain where type = 'REGION' and code = 'AFR'), 0);
insert into Domain(code, name, type,parent,version) values('SLE','Sierra Leone','COUNTRY', (select id from domain where type = 'REGION' and code = 'AFR'), 0);
insert into Domain(code, name, type,parent,version) values('SGP','Singapore','COUNTRY', (select id from domain where type = 'REGION' and code = 'ASI'), 0);
insert into Domain(code, name, type,parent,version) values('SXM','Sint Maarten (Dutch part)','COUNTRY', (select id from domain where type = 'REGION' and code = 'NAM'), 0);
insert into Domain(code, name, type,parent,version) values('SVK','Slovakia','COUNTRY', (select id from domain where type = 'REGION' and code = 'EUR'), 0);
insert into Domain(code, name, type,parent,version) values('SVN','Slovenia','COUNTRY', (select id from domain where type = 'REGION' and code = 'EUR'), 0);
insert into Domain(code, name, type,parent,version) values('SLB','Solomon Islands','COUNTRY', (select id from domain where type = 'REGION' and code = 'AUS'), 0);
insert into Domain(code, name, type,parent,version) values('SOM','Somalia','COUNTRY', (select id from domain where type = 'REGION' and code = 'AFR'), 0);
insert into Domain(code, name, type,parent,version) values('ZAF','South Africa','COUNTRY', (select id from domain where type = 'REGION' and code = 'AFR'), 0);
insert into Domain(code, name, type,parent,version) values('SGS','South Georgia and the South Sandwich Islands','COUNTRY', (select id from domain where type = 'REGION' and code = 'AUS'), 0);
insert into Domain(code, name, type,parent,version) values('SSD','South Sudan','COUNTRY', (select id from domain where type = 'REGION' and code = 'AFR'), 0);
insert into Domain(code, name, type,parent,version) values('ESP','Spain','COUNTRY', (select id from domain where type = 'REGION' and code = 'EUR'), 0);
insert into Domain(code, name, type,parent,version) values('LKA','Sri Lanka','COUNTRY', (select id from domain where type = 'REGION' and code = 'ASI'), 0);
insert into Domain(code, name, type,parent,version) values('SDN','Sudan ','COUNTRY', (select id from domain where type = 'REGION' and code = 'AFR'), 0);
insert into Domain(code, name, type,parent,version) values('SUR','Suriname','COUNTRY', (select id from domain where type = 'REGION' and code = 'SAM'), 0);
insert into Domain(code, name, type,parent,version) values('SJM','Svalbard and Jan Mayen','COUNTRY', (select id from domain where type = 'REGION' and code = 'EUR'), 0);
insert into Domain(code, name, type,parent,version) values('SWZ','Swaziland','COUNTRY', (select id from domain where type = 'REGION' and code = 'AFR'), 0);
insert into Domain(code, name, type,parent,version) values('SWE','Sweden','COUNTRY', (select id from domain where type = 'REGION' and code = 'EUR'), 0);
insert into Domain(code, name, type,parent,version) values('CHE','Switzerland','COUNTRY', (select id from domain where type = 'REGION' and code = 'EUR'), 0);
insert into Domain(code, name, type,parent,version) values('SYR','Syrian Arab Republic','COUNTRY', (select id from domain where type = 'REGION' and code = 'EUR'), 0);
insert into Domain(code, name, type,parent,version) values('TWN','Taiwan','COUNTRY', (select id from domain where type = 'REGION' and code = 'ASI'), 0);
insert into Domain(code, name, type,parent,version) values('TJK','Tajikistan','COUNTRY', (select id from domain where type = 'REGION' and code = 'ASI'), 0);
insert into Domain(code, name, type,parent,version) values('TZA','Tanzania, United Republic of','COUNTRY', (select id from domain where type = 'REGION' and code = 'AFR'), 0);
insert into Domain(code, name, type,parent,version) values('THA','Thailand','COUNTRY', (select id from domain where type = 'REGION' and code = 'ASI'), 0);
insert into Domain(code, name, type,parent,version) values('TLS','Timor-Leste','COUNTRY', (select id from domain where type = 'REGION' and code = 'ASI'), 0);
insert into Domain(code, name, type,parent,version) values('TGO','Togo','COUNTRY', (select id from domain where type = 'REGION' and code = 'AFR'), 0);
insert into Domain(code, name, type,parent,version) values('TKL','Tokelau','COUNTRY', (select id from domain where type = 'REGION' and code = 'AUS'), 0);
insert into Domain(code, name, type,parent,version) values('TON','Tonga','COUNTRY', (select id from domain where type = 'REGION' and code = 'AUS'), 0);
insert into Domain(code, name, type,parent,version) values('TTO','Trinidad and Tobago','COUNTRY', (select id from domain where type = 'REGION' and code = 'NAM'), 0);
insert into Domain(code, name, type,parent,version) values('TUN','Tunisia','COUNTRY', (select id from domain where type = 'REGION' and code = 'AFR'), 0);
insert into Domain(code, name, type,parent,version) values('TUR','Turkey','COUNTRY', (select id from domain where type = 'REGION' and code = 'EUR'), 0);
insert into Domain(code, name, type,parent,version) values('TKM','Turkmenistan','COUNTRY', (select id from domain where type = 'REGION' and code = 'ASI'), 0);
insert into Domain(code, name, type,parent,version) values('TCA','Turks and Caicos Islands ','COUNTRY', (select id from domain where type = 'REGION' and code = 'NAM'), 0);
insert into Domain(code, name, type,parent,version) values('TUV','Tuvalu','COUNTRY', (select id from domain where type = 'REGION' and code = 'AUS'), 0);
insert into Domain(code, name, type,parent,version) values('UGA','Uganda','COUNTRY', (select id from domain where type = 'REGION' and code = 'AFR'), 0);
insert into Domain(code, name, type,parent,version) values('UKR','Ukraine','COUNTRY', (select id from domain where type = 'REGION' and code = 'EUR'), 0);
insert into Domain(code, name, type,parent,version) values('ARE','United Arab Emirates ','COUNTRY', (select id from domain where type = 'REGION' and code = 'ASI'), 0);
insert into Domain(code, name, type,parent,version) values('GBR','United Kingdom','COUNTRY', (select id from domain where type = 'REGION' and code = 'EUR'), 0);
insert into Domain(code, name, type,parent,version) values('UMI','United States Minor Outlying Islands ','COUNTRY', (select id from domain where type = 'REGION' and code = 'NAM'), 0);
insert into Domain(code, name, type,parent,version) values('USA','United States of America ','COUNTRY', (select id from domain where type = 'REGION' and code = 'NAM'), 0);
insert into Domain(code, name, type,parent,version) values('URY','Uruguay','COUNTRY', (select id from domain where type = 'REGION' and code = 'SAM'), 0);
insert into Domain(code, name, type,parent,version) values('UZB','Uzbekistan','COUNTRY', (select id from domain where type = 'REGION' and code = 'ASI'), 0);
insert into Domain(code, name, type,parent,version) values('VUT','Vanuatu','COUNTRY', (select id from domain where type = 'REGION' and code = 'US'), 0);
insert into Domain(code, name, type,parent,version) values('VEN','Venezuela','COUNTRY', (select id from domain where type = 'REGION' and code = 'SAM'), 0);
insert into Domain(code, name, type,parent,version) values('VNM','Vietnam','COUNTRY', (select id from domain where type = 'REGION' and code = 'ASI'), 0);
insert into Domain(code, name, type,parent,version) values('VGB','Virgin Islands (British)','COUNTRY', (select id from domain where type = 'REGION' and code = 'NAM'), 0);
insert into Domain(code, name, type,parent,version) values('VIR','Virgin Islands (U.S.)','COUNTRY', (select id from domain where type = 'REGION' and code = 'NAM'), 0);
insert into Domain(code, name, type,parent,version) values('WLF','Wallis and Futuna','COUNTRY', (select id from domain where type = 'REGION' and code = 'AUS'), 0);
insert into Domain(code, name, type,parent,version) values('ESH','Western Sahara','COUNTRY', (select id from domain where type = 'REGION' and code = 'AFR'), 0);
insert into Domain(code, name, type,parent,version) values('YEM','Yemen','COUNTRY', (select id from domain where type = 'REGION' and code = 'ASI'), 0);
insert into Domain(code, name, type,parent,version) values('ZMB','Zambia','COUNTRY', (select id from domain where type = 'REGION' and code = 'AFR'), 0);
insert into Domain(code, name, type,parent,version) values('ZWE','Zimbabwe','COUNTRY', (select id from domain where type = 'REGION' and code = 'AFR'), 0);
insert into Domain(code, name, type,parent,version) values('WOW','Worldwide','COUNTRY', (select id from domain where type = 'REGION' and code = 'WOW'), 0);
insert into Domain(code, name, type,parent,version) values('UNK','Unknown','COUNTRY', (select id from domain where type = 'REGION' and code = 'UNK'), 0);

CREATE TABLE organization
(
	id                   SERIAL NOT NULL,
	leader               INTEGER NULL,
	name                 VARCHAR(255) NOT NULL,
	headquarters         VARCHAR(255) NOT NULL,
	address              VARCHAR(255) NOT NULL,
	country_of_origin    INTEGER NOT NULL, 
	member_count         INTEGER NOT NULL,    
	government_sponsored BOOLEAN NOT NULL,
	version              INTEGER NULL,
	yearly_mortality_rate NUMERIC(18,9),
	reputation           VARCHAR(100) NULL,
	url 				 VARCHAR(255),
	main_activity        INTEGER NULL,
	PRIMARY KEY (id)
);


CREATE INDEX organization_idx1 ON organization
(
	country_of_origin
);

CREATE INDEX organization_idx2 ON organization
(
	leader
);

DELETE FROM organization;

ALTER TABLE organization
ADD CONSTRAINT fk_organization_domain FOREIGN KEY (country_of_origin) REFERENCES domain(id) ON DELETE CASCADE;

ALTER TABLE organization
ADD CONSTRAINT fk_organization_main_activity FOREIGN KEY (main_activity) REFERENCES domain(id) ON DELETE CASCADE;

INSERT INTO organization(name,headquarters,address,country_of_origin, member_count, government_sponsored, yearly_mortality_rate, reputation, version)
  VALUES ('CamelCase Camorra', 'Vinnies Pizzeria', '25 Vina Del Mar', (select id from domain where code = 'ITA' and type = 'COUNTRY'),434, true, 3.4, 'FEARSOME', 0);

INSERT INTO organization(name,headquarters,address,country_of_origin, member_count, government_sponsored, yearly_mortality_rate, reputation, version)
  VALUES ('Coda Nostra', 'Snow White Warehouse', '678 Corleone Boulevard', (select id from domain where code = 'ITA' and type = 'COUNTRY'),187, true, 7.6, 'EXTREMELY_FEARSOME', 0);

INSERT INTO organization(name,headquarters,address,country_of_origin, member_count, government_sponsored, yearly_mortality_rate, reputation, version)
  VALUES ('Garbage Collection Gang', 'Billies Bar and Grill', '1543 Griffith Avenue', (select id from domain where code = 'USA' and type = 'COUNTRY'),97, true, 2.6, 'MILDLY_FEARSOME', 0);

INSERT INTO organization(name,headquarters,address,country_of_origin, member_count, government_sponsored, yearly_mortality_rate, reputation, version)
  VALUES ('Los Pollos Hermanos', 'Los Pollos Hermanos', '67 South Side Drive', (select id from domain where code = 'MEX' and type = 'COUNTRY'),800, true, 5.5, 'FEARSOME', 0);

INSERT INTO organization(name,headquarters,address,country_of_origin, member_count, government_sponsored, yearly_mortality_rate, reputation, version)
  VALUES ('Horror Clown Consortium', 'Rusty''s Fun House', '122 Giggles Road', (select id from domain where code = 'AUS' and type = 'COUNTRY'),75, false, 6.4, 'REALLY_NOT_FEARSOME', 0);

CREATE TABLE person
(
	id                   SERIAL NOT NULL,
	first_name           VARCHAR(255) NOT NULL,
	last_name            VARCHAR(255) NOT NULL,
	nickname             VARCHAR(255) NOT NULL,
	version              INTEGER NULL,
	organization         INTEGER NOT NULL,
	born                 DATE NULL,
	died                 DATE NULL,
	PRIMARY KEY (id)
);

CREATE INDEX person_idx1 ON person
(
	organization
);



ALTER TABLE person
ADD CONSTRAINT fk_person_organisation FOREIGN KEY (organization) REFERENCES organization(id) ON DELETE CASCADE;

DELETE FROM person;

INSERT INTO person(first_name, last_name, nickname, version, organization, born, died) VALUES 
   ('Giovanni','Genarro', 'Generic', 0, (select id from organization where name = 'CamelCase Camorra'), '14-02-1952', null);

INSERT INTO person(first_name, last_name, nickname, version, organization, born, died) VALUES 
   ('Vinnie','Vicenzo', 'The Vector', 0, (select id from organization where name = 'CamelCase Camorra'), '01-04-1963', null);

INSERT INTO person(first_name, last_name, nickname, version, organization, born, died) VALUES 
   ('Rudolfo','Renzi', 'Red Hat', 0, (select id from organization where name = 'CamelCase Camorra'), '01-07-1940', null);

INSERT INTO person(first_name, last_name, nickname, version, organization, born, died) VALUES 
   ('Nicky','Nicoletti', 'The Nullpointer', 0, (select id from organization where name = 'Coda Nostra'), '12-10-1937', null);

INSERT INTO person(first_name, last_name, nickname, version, organization, born, died) VALUES 
   ('Eros','Enoldi', 'Exceptional', 0, (select id from organization where name = 'Coda Nostra'), '12-03-1975', null);

INSERT INTO person(first_name, last_name, nickname, version, organization, born, died) VALUES 
   ('Dicky','Danza', 'Deadlock', 0, (select id from organization where name = 'Coda Nostra'), '12-04-1984', null);

INSERT INTO person(first_name, last_name, nickname, version, organization, born, died) VALUES 
   ('Billie', 'Boid', 'Binary', 0, (select id from organization where name = 'Garbage Collection Gang'), '03-02-1939', null);

INSERT INTO person(first_name, last_name, nickname, version, organization, born, died) VALUES 
   ('Stephen', 'Sommersby', 'Stack Overflow', 0, (select id from organization where name = 'Garbage Collection Gang'), '03-02-1939', null);

INSERT INTO person(first_name, last_name, nickname, version, organization, born, died) VALUES 
   ('Hank', 'Hendrix', 'Heap Space', 0, (select id from organization where name = 'Garbage Collection Gang'), '01-08-1955', null);

INSERT INTO person(first_name, last_name, nickname, version, organization, born, died) VALUES 
   ('Manuel', 'Manolo', 'Read the f*cking Manual', 0, (select id from organization where name = 'Los Pollos Hermanos'), '01-08-1984', null);

INSERT INTO person(first_name, last_name, nickname, version, organization, born, died) VALUES 
   ('Octavio', 'Octaviani', 'Open Source', 0, (select id from organization where name = 'Los Pollos Hermanos'), '04-05-1974', null);

INSERT INTO person(first_name, last_name, nickname, version, organization, born, died) VALUES 
   ('Hector', 'Delgado', 'The Hacker', 0, (select id from organization where name = 'Los Pollos Hermanos'), '10-08-1980', null);

INSERT INTO person(first_name, last_name, nickname, version, organization, born, died) VALUES 
   ('Pipo', 'Peters', 'Pipo' ,0, (select id from organization where name = 'Horror Clown Consortium'), '01-01-1945', null);

INSERT INTO person(first_name, last_name, nickname, version, organization, born, died) VALUES 
   ('Bassie', 'Van Toor', 'Allemenaggies', 0, (select id from organization where name = 'Horror Clown Consortium'), '06-05-1971', null);

INSERT INTO person(first_name, last_name, nickname, version, organization, born, died) VALUES 
   ('William', 'Wartaal', 'Wallace', 0, (select id from organization where name = 'Horror Clown Consortium'), '01-01-1965', null);

CREATE TABLE gift
(
	id                   SERIAL NOT NULL,
	name                 VARCHAR(255) NOT NULL,
	description 	     VARCHAR(255) NOT NULL,
	logo                 INTEGER NULL,
	version              INTEGER NULL,
	PRIMARY KEY (id)     
);

CREATE TABLE gift_logo( 
	id                   SERIAL NOT NULL,
	image                oid NULL,
	filename             VARCHAR(255) NULL,
	version              INTEGER NULL,
	PRIMARY KEY (id)     
);

ALTER TABLE gift ADD CONSTRAINT fk_gift_logo FOREIGN KEY (logo) REFERENCES gift_logo(id) ON DELETE CASCADE;

DELETE FROM gift;

INSERT INTO gift_logo(image, version) values(null,0);
INSERT INTO gift(name,description,version, logo) values ('My Little Pony', 'A beloved starter model', 0, (select max(id) from gift_logo));

INSERT INTO gift_logo(image, version) values(null,0);
INSERT INTO gift(name,description,version,logo) values ('Arabic Full Breed', 'An ISIS favorite', 0, (select max(id) from gift_logo));

INSERT INTO gift_logo(image, version) values(null,0);
INSERT INTO gift(name,description,version,logo) values ('Stick Horse', '(Relatively) animal friendly', 0, (select max(id) from gift_logo));

INSERT INTO gift_logo(image, version) values(null,0);
INSERT INTO gift(name,description,version,logo) values ('Sea Horse', 'Perfect for intimidating pirates', 0, (select max(id) from gift_logo));

INSERT INTO gift_logo(image, version) values(null,0);
INSERT INTO gift(name,description,version,logo) values ('Przewalski''s horse', 'A hit at the National Dictee', 0, (select max(id) from gift_logo));

INSERT INTO gift_logo(image, version) values(null,0);
INSERT INTO gift(name,description,version,logo) values ('Schimmel', 'Very popular as part of the ongoing Black Pete discussion', 0, (select max(id) from gift_logo));

INSERT INTO gift_logo(image, version) values(null,0);
INSERT INTO gift(name,description,version,logo) values ('Trojan Horse', 'Who knows what might be inside', 0, (select max(id) from gift_logo));

INSERT INTO gift_logo(image, version) values(null,0);
INSERT INTO gift(name,description,version,logo) values ('Lippizaner', 'For conaisseurs only', 0, (select max(id) from gift_logo));

INSERT INTO gift_logo(image, version) values(null,0);
INSERT INTO gift(name,description,version,logo) values ('Racing Horse', 'Guaranteed same day delivery', 0, (select max(id) from gift_logo));

CREATE TABLE gift_translations
(
	id                   SERIAL NOT NULL,
	gift                 INTEGER NOT NULL,
	language             VARCHAR(255) NOT NULL,
	description          VARCHAR(255) NOT NULL,
	version              INTEGER NULL,
	PRIMARY KEY (id)     
);

ALTER TABLE gift_translations ADD CONSTRAINT fk_gift_translations_gift FOREIGN KEY (gift) REFERENCES gift(id) ON DELETE CASCADE;


CREATE TABLE delivery
(
	id                   SERIAL NOT NULL,
	from_person          INTEGER NOT NULL,
	to_person            INTEGER NOT NULL,
	gift                 INTEGER NOT NULL,
	date                 DATE,
	remarks              VARCHAR(255),
	version              INTEGER NULL,	
	PRIMARY KEY (id)
);

CREATE INDEX delivery_idx1 ON delivery
(
	from_person
);

CREATE INDEX delivery_idx2 ON delivery
(
	to_person
);

CREATE INDEX delivery_idx3 ON delivery
(
	gift
);

ALTER TABLE delivery
ADD CONSTRAINT fk_delivery_person1 FOREIGN KEY (from_person) REFERENCES person(id) ON DELETE CASCADE;

ALTER TABLE delivery
ADD CONSTRAINT fk_delivery_person2 FOREIGN KEY (to_person) REFERENCES person(id) ON DELETE CASCADE;

ALTER TABLE delivery
ADD CONSTRAINT fk_delivery_person3 FOREIGN KEY (gift) REFERENCES gift(id) ON DELETE CASCADE;

