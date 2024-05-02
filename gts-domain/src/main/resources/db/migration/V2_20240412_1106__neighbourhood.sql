CREATE TABLE neighbourhood(
	id SERIAL NOT NULL,
    name text NOT NULL,
    version integer NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE organization_neighbourhood(
    organization_id integer NOT NULL,
    neighbourhood_id integer NOT NULL,
    CONSTRAINT fk_org_nb_neighbourhood FOREIGN KEY (neighbourhood_id)
        REFERENCES public.neighbourhood (id) ON DELETE CASCADE,
    CONSTRAINT fk_org_nb_organization FOREIGN KEY (organization_id)
        REFERENCES public.organization (id) ON DELETE CASCADE
);

insert into neighbourhood(name,version) values ('Laakkwartier',0);
insert into neighbourhood(name,version) values ('Schilderswijk',0);
insert into neighbourhood(name,version) values ('Rivierenbuurt',0);
