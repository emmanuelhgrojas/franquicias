-- 1. Habilitar extensión para generación de UUIDs
CREATE EXTENSION IF NOT EXISTS pgcrypto WITH SCHEMA public;

-- 2. Tabla: franquicias
CREATE TABLE IF NOT EXISTS public.franquicias (
    fran_id UUID DEFAULT public.gen_random_uuid() NOT NULL,
    nombre VARCHAR(255) NOT NULL,
    estado VARCHAR(255) DEFAULT 'AC'::character varying NOT NULL,
    fecha TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP NOT NULL,
    CONSTRAINT franquicias_pkey PRIMARY KEY (fran_id)
);

-- 3. Tabla: sucursales
CREATE TABLE IF NOT EXISTS public.sucursales (
    sucu_id UUID DEFAULT public.gen_random_uuid() NOT NULL,
    nombre VARCHAR(255) NOT NULL,
    estado VARCHAR(255) DEFAULT 'AC'::character varying NOT NULL,
    franq_id UUID NOT NULL,
    fecha TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP NOT NULL,
    CONSTRAINT sucursales_pkey PRIMARY KEY (sucu_id),
    CONSTRAINT sucursales_franq_id_fkey FOREIGN KEY (franq_id) 
        REFERENCES public.franquicias(fran_id)
);

-- 4. Tabla: productos
CREATE TABLE IF NOT EXISTS public.productos (
    prod_id UUID DEFAULT public.gen_random_uuid() NOT NULL,
    nombre VARCHAR(255) NOT NULL,
    stock INTEGER NOT NULL,
    estado VARCHAR(255) DEFAULT 'AC'::character varying NOT NULL,
    sucu_id UUID NOT NULL,
    fecha TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP NOT NULL,
    CONSTRAINT productos_pkey PRIMARY KEY (prod_id),
    CONSTRAINT productos_sucu_id_fkey FOREIGN KEY (sucu_id) 
        REFERENCES public.sucursales(sucu_id)
);