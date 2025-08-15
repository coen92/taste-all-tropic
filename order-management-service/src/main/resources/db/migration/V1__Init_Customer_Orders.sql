CREATE TABLE IF NOT EXISTS customer_orders (
    customer_id UUID PRIMARY KEY,
    created_at TIMESTAMP NOT NULL,
    updated_at TIMESTAMP,
    version INTEGER NOT NULL,
    payload JSONB
);
