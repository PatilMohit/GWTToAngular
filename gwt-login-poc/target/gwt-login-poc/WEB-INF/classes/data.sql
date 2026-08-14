INSERT INTO app_user (username, password) VALUES ('admin', 'admin123') ON CONFLICT (username) DO NOTHING;
